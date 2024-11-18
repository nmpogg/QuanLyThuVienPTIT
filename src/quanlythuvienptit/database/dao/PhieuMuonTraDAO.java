/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlythuvienptit.database.DataBaseConnection;
/**
 *
 * @author NguyenXuanKhuong
 */
public class PhieuMuonTraDAO {
    
    public DefaultTableModel search(String s) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT ID_MuonTra, MaTL, MaDG, NgayMuon, HanTra " +
                         "FROM PhieuMuonTra " +
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            String[] col = {"STT", "Mã phiếu mượn", "Mã sách", "Số thẻ", "Tên sách", "Ngày mượn", "Hạn trả"};
            ResultSet rs = ps.executeQuery();
            ArrayList<Object[]> arr = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Object[] row = new Object[7];
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
                arr.add(row);
            }
            if(!arr.isEmpty()){
                Object[][] row = new Object[arr.size()][7];
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
    public String getTinhTrang(String s){
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
    
    public void deletePhieu(String s){
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
}
