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
import quanlythuvienptit.models.HienThiBDK;
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
            String sql = "SELECT ID_MuonTra, MaDG, NgayMuon, HanTra " +
                         "FROM PhieuMuonTra " +
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            String[] col = {"STT", "Mã PM", "Mã sách", "Số thẻ", "Tên sách", "Ngày mượn", "Hạn trả"};
            ResultSet rs = ps.executeQuery();
            ArrayList<Object[]> arr = new ArrayList<>();
            int cnt = 1;
            while(rs.next()){
                Object[] row = new Object[7];
                row[1] = rs.getString("ID_MuonTra");
                row[3] = rs.getString("MaDG");
                row[5] = rs.getString("NgayMuon");
                row[6] = rs.getString("HanTra");
                String sql2 = "SELECT TenTL FROM TaiLieu " +
                                  "WHERE MaTL = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ArrayList<String> dsMaTL = Phieu_TLDAO.getMaTL((String)row[1]);
                for(String idTL : dsMaTL){
                    row[0] = cnt++;
                    row[2] = idTL;
                    ps2.setString(1, (String)row[2]);
                    ResultSet rs2 = ps2.executeQuery();
                    if(rs2.next()){
                        row[4] = rs2.getString("TenTL");
                    }
                    Object[] rowClone = row.clone();
                    if(Phieu_TLDAO.getTrangThaiMuonTra((String)row[1], idTL).equals("Chưa trả")){
                        arr.add(rowClone);
                    }
                }
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
    
    public static void deletePhieu(String s){
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "DELETE FROM PhieuMuonTra " +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertPhieu(PhieuMuonTra t){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "INSERT INTO PhieuMuonTra " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getID_MuonTra());
            ps.setString(2, t.getMaDG());
            //ps.setString(3, t.getMaTL());
            ps.setString(3, t.getKieuMuon());
            ps.setString(4, t.getNgayMuon());
            ps.setString(5, t.getNguoiChoMuon());
            ps.setString(6, t.getHanTra());
            //ps.setString(8, t.getTrangThaiMuonTra());
            ps.setString(7, t.getNguoiNhan());
            //ps.setString(10, t.getTinhTrangMuon());
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
            else idMuonTraMax = "";
        }catch(Exception e){
            e.printStackTrace();
        }
        return idMuonTraMax;
    }
    /*
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
    */
    
    public static ArrayList<Object[]> thongKePhieu(){
        ArrayList<Object[]> dsPhieu = new ArrayList<>();
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT ID_MuonTra, MaDG, NgayMuon, HanTra FROM PhieuMuonTra";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int cnt = 1;
            while(rs.next()){
                Object[] row = new Object[8];
                row[0] = cnt++;
                row[1] = rs.getString("ID_MuonTra");
                row[2] = rs.getString("MaDG");
                String tenDG = DocGiaDAO.getTenDG((String)row[2]);
                row[3] = tenDG;
                int soSachMuon = Phieu_TLDAO.getSoSachMuon((String)row[1]);
                int soSachDaTra = Phieu_TLDAO.getSoSachDaTra((String)row[1]);
                row[4] = soSachMuon;
                row[5] = soSachDaTra;
                row[6] = rs.getString("NgayMuon");
                row[7] = rs.getString("HanTra");
                dsPhieu.add(row);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsPhieu;
    }
    
    public static ResultSet getChiTietPhieu(String maPhieu){
        ResultSet rs = null;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT ID_MuonTra, MaDG, KieuMuon, NgayMuon, NguoiChoMuon, HanTra FROM PhieuMuonTra " +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPhieu);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public ArrayList<HienThiBDK> hienthibdk(){
        ArrayList<HienThiBDK> list = new ArrayList<>();
        ResultSet rs = null;
        try{
            Connection con = DataBaseConnection.getConnection();
            String s = "tại chỗ";
            String sql = "SELECT DocGia.MaDG AS MaDocGia,DocGia.HoTen AS TenDocGia,COUNT(Phieu_TaiLieu.MaTL) AS SoTaiLieuMuon "+
                    "FROM  phieumuontra "+
                    "LEFT JOIN docgia ON DocGia.MaDG = PhieuMuonTra.MaDG "+
                    "LEFT JOIN Phieu_TaiLieu ON PhieuMuonTra.ID_MuonTra = Phieu_TaiLieu.ID_MuonTra "+
                    "WHERE phieumuontra.KieuMuon = ?" +
                    "GROUP BY DocGia.MaDG, DocGia.HoTen;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            rs = ps.executeQuery();
           while(rs.next()){
               HienThiBDK a = new HienThiBDK();
               a.setMaDG(rs.getString("MaDocGia"));
               a.setTenDG(rs.getString("TenDocGia"));
               a.setSoSach(rs.getString("SoTaiLieuMuon"));
               list.add(a);
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public static void updateNguoiChoMuon(String id, String nguoiChoMuon){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE PhieuMuonTra SET NguoiChoMuon = ?" +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nguoiChoMuon);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateKieuMuon(String id, String kieuMuon){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE PhieuMuonTra SET KieuMuon = ?" +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kieuMuon);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateHanTra(String id, String hanTra){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE PhieuMuonTra SET HanTra = ?" +
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hanTra);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
