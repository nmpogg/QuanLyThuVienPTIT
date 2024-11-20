/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

import quanlythuvienptit.database.DataBaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlythuvienptit.models.TaiLieu;

/**
 *
 * @author NguyenXuanKhuong
 */
public class TaiLieuDAO {

    public void insert(TaiLieu t) {
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "INSERT INTO TaiLieu " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaTL());
            ps.setString(2, t.getTenTL());
            ps.setString(3, t.getMaKhoa());
            ps.setString(4, t.getMaNXB());
            ps.setInt(5, t.getNamXB());
            ps.setString(6, t.getMaTG());
            ps.setInt(7, t.getSoLuong());
            ps.setInt(8, t.getConLai());
            ps.setString(9, t.getKeSach());
            ps.setString(10, t.getTinhTrang());
            ps.setString(11, t.getGhiChu());
     
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm sách thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không thể thêm sách. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không thể thêm sách. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public DefaultTableModel search(String s){
        DefaultTableModel model = null;
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT * FROM TaiLieu " +
                         "WHERE tenTL LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            ResultSet rs = ps.executeQuery();
            String[] col = {"STT", "Mã tài liệu", "Tên tài liệu", "Mã khoa", "Mã NXB", "Năm XB", "Mã thể loại", "Mã tác giả", "Số lượng","Còn lại", "Kệ sách", "Tình trạng", "Ghi chú"};
            ArrayList<Object[]> arr = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Object[] row = new Object[13];
                row[0] = cnt++;
                row[1] = rs.getString("MaTL");
                row[2] = rs.getString("TenTL");
                row[3] = rs.getString("MaKhoa");
                row[4] = rs.getString("MaNXB");
                row[5] = rs.getInt("NamXB");
                row[6] = rs.getString("MaTheLoai");
                row[7] = rs.getString("MaTG");
                row[8] = rs.getInt("SoLuong");
                row[9] = rs.getInt("ConLai");
                row[10] = rs.getString("KeSach");
                row[11] = rs.getString("TinhTrang");
                row[12] = rs.getString("GhiChu");
                arr.add(row);
            }
            if(!arr.isEmpty()){
                Object[][] row = new Object[arr.size()][13];
                for(int i = 0; i < arr.size(); i++){
                    row[i] = arr.get(i);
                }
                model = new DefaultTableModel(row, col);
            }
            else{
                model = new DefaultTableModel(col, 4);
                JOptionPane.showMessageDialog(null, "Không tìm thấy sách!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel qlpm_SearchSach(String s){
        DefaultTableModel model = null;
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT * FROM TaiLieu " +
                         "WHERE tenTL LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            ResultSet rs = ps.executeQuery();
            String[] col = {"Mã tài liệu", "Tên tài liệu", "Tác giả", "Ngành", "Còn lại"};
            ArrayList<Object[]> arr = new ArrayList<>();
            while(rs.next()){
                Object[] row = new Object[5];
                row[0] = rs.getString("MaTL");
                row[1] = rs.getString("TenTL");
                String idTG = rs.getString("MaTG");
                String sql2 = "SELECT TenTG FROM TacGia " + 
                              "WHERE MaTG = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setString(1, idTG);
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                row[2] = rs2.getString("TenTG");
                String idKhoa = rs.getString("MaKhoa");
                String sql3 = "SELECT TenKhoa FROM KHOA " +
                              "WHERE MaKhoa = ?";
                PreparedStatement ps3 = con.prepareStatement(sql3);
                ps3.setString(1, idKhoa);
                ResultSet rs3 = ps3.executeQuery();
                rs3.next();
                row[3] = rs3.getString("TenKhoa");
                row[4] = rs.getInt("ConLai");
                arr.add(row);
            }
            if(!arr.isEmpty()){
                Object[][] row = new Object[arr.size()][5];
                for(int i = 0; i < arr.size(); i++){
                    row[i] = arr.get(i);
                }
                model = new DefaultTableModel(row, col);
            }
            else{
                model = new DefaultTableModel(col, 4);
                JOptionPane.showMessageDialog(null, "Không tìm thấy sách!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
