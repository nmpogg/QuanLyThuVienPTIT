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
    
    //qls:
    public static void insert(TaiLieu t) {
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
    
    public static DefaultTableModel search(String s, String khoa){
        DefaultTableModel model = null;
        if(khoa == "none"){
            try {
                Connection con = DataBaseConnection.getConnection();
                String sql = "SELECT MaTL, TenTL, MaKhoa, MaTG, SoLuong, ConLai FROM TaiLieu " +
                             "WHERE tenTL LIKE ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%" + s + "%");
                ResultSet rs = ps.executeQuery();
                String[] col = {"STT", "Mã tài liệu", "Tên tài liệu", "Khoa", "Tác giả", "Số lượng","Còn lại"};
                ArrayList<Object[]> arr = new ArrayList<>();
                int cnt = 1;
                while(rs.next()){
                    Object[] row = new Object[7];
                    row[0] = cnt++;
                    row[1] = rs.getString("MaTL");
                    row[2] = rs.getString("TenTL");

                    String maKhoa = rs.getString("MaKhoa");
                    String sql2 = "SELECT TenKhoa FROM Khoa " +
                                  "WHERE MaKhoa = " + "'" + maKhoa + "'";
                    Statement stmt1 = con.createStatement();
                    ResultSet rs2 = stmt1.executeQuery(sql2);
                    if(rs2.next()){
                        row[3] = rs2.getString("TenKhoa");
                    }

                    String maTG = rs.getString("MaTG");
                    String sql3 = "SELECT TenTG FROM TacGia " +
                                  "WHERE MaTG = " + "'" + maTG + "'";
                    Statement stmt2 = con.createStatement();
                    ResultSet rs3 = stmt1.executeQuery(sql3);
                    if(rs3.next()){
                        row[4] = rs3.getString("TenTG");
                    }

                    row[5] = rs.getInt("SoLuong");
                    row[6] = rs.getInt("ConLai");
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
        }
        else{
            try {
                Connection con = DataBaseConnection.getConnection();
                String idKhoa = KhoaDAO.searchMaKhoa(khoa);
                String sql1 = "SELECT MaTL, TenTL, MaKhoa, MaTG, SoLuong, ConLai FROM TaiLieu " +
                             "WHERE tenTL LIKE ? AND MaKhoa = ?";
                PreparedStatement ps = con.prepareStatement(sql1);
                ps.setString(1, "%" + s + "%");
                ps.setString(2, idKhoa);
                ResultSet rs = ps.executeQuery();
                String[] col = {"STT", "Mã tài liệu", "Tên tài liệu", "Khoa", "Tác giả", "Số lượng","Còn lại"};
                ArrayList<Object[]> arr = new ArrayList<>();
                int cnt = 1;
                while(rs.next()){
                    Object[] row = new Object[7];
                    row[0] = cnt++;
                    row[1] = rs.getString("MaTL");
                    row[2] = rs.getString("TenTL");

                    String maKhoa = rs.getString("MaKhoa");
                    String sql2 = "SELECT TenKhoa FROM Khoa " +
                                  "WHERE MaKhoa = " + "'" + maKhoa + "'";
                    Statement stmt1 = con.createStatement();
                    ResultSet rs2 = stmt1.executeQuery(sql2);
                    if(rs2.next()){
                        row[3] = rs2.getString("TenKhoa");
                    }

                    String maTG = rs.getString("MaTG");
                    String sql3 = "SELECT TenTG FROM TacGia " +
                                  "WHERE MaTG = " + "'" + maTG + "'";
                    Statement stmt2 = con.createStatement();
                    ResultSet rs3 = stmt1.executeQuery(sql3);
                    if(rs3.next()){
                        row[4] = rs3.getString("TenTG");
                    }

                    row[5] = rs.getInt("SoLuong");
                    row[6] = rs.getInt("ConLai");
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
        }
        return model;
    }
    
    public static String getMaTL_Max(){
        String maTL = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MAX(MaTL) AS MaTLMax FROM TaiLieu";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                maTL = rs.getString("MaTLMax");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maTL;
    }
    
    //qlpm:
    public static DefaultTableModel qlpm_SearchSach(String s){
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
