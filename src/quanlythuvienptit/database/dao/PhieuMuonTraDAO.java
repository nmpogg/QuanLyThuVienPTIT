/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlythuvienptit.database.DataBaseConnection;
import quanlythuvienptit.models.PhieuMuonTra;
/**
 *
 * @author NguyenXuanKhuong
 */
public class PhieuMuonTraDAO {
    
    public static DefaultTableModel search(String s) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT ID_MuonTra, MaTL, MaDG, NgayMuon, HanTra, TrangThaiMuonTra " +
                         "FROM PhieuMuonTra " +
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            String[] col = {"STT", "Mã PM", "Mã sách", "Số thẻ", "Tên sách", "Ngày mượn", "Hạn trả", "Trạng thái"};
            ResultSet rs = ps.executeQuery();
            ArrayList<Object[]> arr = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Object[] row = new Object[8];
                row[0] = cnt++;
                row[1] = rs.getString("ID_MuonTra");
                row[2] = rs.getString("MaTL");
                row[3] = rs.getString("MaDG");
                
                String sql2 = "SELECT TenTL FROM TaiLieu " +
                              "WHERE MaTL = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setString(1, (String)row[2]);
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                row[4] = rs2.getString("TenTL");
                row[5] = rs.getString("NgayMuon");
                row[6] = rs.getString("HanTra");
                row[7] = rs.getString("TrangThaiMuonTra");
                arr.add(row);
            }
            if(!arr.isEmpty()){
                Object[][] row = new Object[arr.size()][8];
                for(int i = 0; i < arr.size(); i++){
                    row[i] = arr.get(i);
                }
                model = new DefaultTableModel(row, col);
            }
            else{
                model = new DefaultTableModel(col, 0);
                JOptionPane.showMessageDialog(null, "Không tìm thấy sách!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    /*
    public static String getTinhTrang(String s){
        String tinhTrang = "";
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TinhTrangTra " +
                         "FROM PhieuMuonTra " +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            rs.next();
            tinhTrang = rs.getString("TinhTrangTra");
            return tinhTrang;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tinhTrang;
    }
    */
    /*
    public static void deletePhieu(String s){
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "DELETE FROM PhieuMuonTra " +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    */
    
    public static void insertPhieu(PhieuMuonTra t){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "INSERT INTO PhieuMuonTra " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getID_MuonTra());
            ps.setString(2, t.getMaDG());
            ps.setString(3, t.getMaTL());
            ps.setString(4, t.getKieuMuon());
            ps.setString(5, t.getNgayMuon());
            ps.setString(6, t.getNguoiChoMuon());
            ps.setString(7, t.getHanTra());
            ps.setString(8, t.getTrangThaiMuonTra());
            ps.setString(9, t.getNguoiNhan());
            ps.setString(10, t.getTinhTrangMuon());
            //ps.setString(11, t.getTinhTrangTra());
            //ps.setString(12, t.getNgayTra());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tạo phiếu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không tạo được phiếu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static String getID_MuonTraMax(){
        String idMuonTraMax = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MAX(ID_MuonTra) AS ID_MuonTraMax FROM PhieuMuonTra";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                idMuonTraMax = rs.getString("ID_MuonTraMax");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return idMuonTraMax;
    }
    
    public static void updateNgayTra(String id){
        try{
            LocalDate today = LocalDate.now();
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE PhieuMuonTra SET NgayTra = " + "'" + today + "' " +
                         "WHERE ID_MuonTra = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateTrangThaiMT(String id){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE PhieuMuonTra SET TrangThaiMuonTra = 'da tra' " +
                         "WHERE ID_MuonTra = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateTinhTrangTra(String id, String tinhTrang){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE PhieuMuonTra SET TinhTrangTra = " + "'" + tinhTrang + "' " +
                         "WHERE ID_MuonTra = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
