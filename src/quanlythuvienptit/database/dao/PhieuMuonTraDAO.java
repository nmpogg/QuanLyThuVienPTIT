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
           DefaultTableModel model = null;
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT ID_MuonTra, MaTL, MaDG, NgayMuon, HanTra " +
                         "FROM PhieuMuonTra" +
                         "WHEWE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            String[] col = {"STT", "Mã phiếu mượn", "Mã sách", "Số thẻ", "Tên sách", "Ngày mượn", "Hạn trả"};
            ResultSet rs = ps.executeQuery();
            ArrayList<Object[]> arr = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Object[] row = new Object[7];
                row[0] = cnt++;
                row[1] = rs.getString("ID_PhieuMuon");
                row[2] = rs.getString("MaTL");
                row[3] = rs.getString("MaDG");
                
                String sql2 = "SELECT MaTG FROM TaiLieu " +
                              "WHERE MaTL = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setString(1, (String)row[2]);
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                String idTG = rs2.getString("MaTG");
                String sql3 = "SELECT TenTG FROM TacGia " +
                              "WHERE MaTG = ?";
                PreparedStatement ps3 = con.prepareStatement(sql3);
                ps3.setString(1, idTG);
                ResultSet rs3 = ps3.executeQuery();
                rs3.next();
                row[4] = rs3.getString("TenTG");
                row[5] = rs.getString("NgayMuon");
                row[6] = rs.getString("HanTra");
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
            //Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(TaiLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
