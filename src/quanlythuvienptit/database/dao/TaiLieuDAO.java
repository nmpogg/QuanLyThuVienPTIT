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
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaTL());
            ps.setString(2, t.getTenTL());
            ps.setString(3, t.getMaKhoa());
            ps.setString(4, t.getMaNXB());
            ps.setString(5, t.getNamXB());
            ps.setString(6, t.getMaTG());
            ps.setInt(7, t.getSoLuong());
            ps.setInt(8, t.getConLai());
            ps.setString(9, t.getKeSach());
            ps.setString(10, t.getTinhTrang());
            ps.setString(11, t.getGhiChu());
            ps.setString(12, t.getStatus());
     
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
        if(khoa == "Tất cả"){
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
    
    public static void deleteSach(String id){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "DELETE FROM TaiLieu " +
                         "WHERE MaTL = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
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
            String[] col = {"Mã tài liệu", "Tên tài liệu", "Tác giả", "Khoa", "Còn lại"};
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
    
    public static String getTinhTrang(String id){
        String tinhTrang = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TinhTrang FROM TaiLieu " +
                         "WHERE MaTL = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                tinhTrang = rs.getString("TinhTrang");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tinhTrang;
    }
    
    public static void updateTinhTrang(String id, String tinhTrang){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TaiLieu SET TinhTrang = " + "'" + tinhTrang + "' " +
                         "WHERE MaTL = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static ResultSet getChiTietSach(String id){
        ResultSet rs = null;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaTL, TenTL, MaKhoa, MaNXB, NamXB, MaTG, KeSach, TinhTrang, GhiChu FROM TaiLieu " + 
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    /*
    public static void update(String id, String tenTL, String namXB, String keSach, String tinhTrang, String ghiChu){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TaiLieu SET TenTL = ?, NamXB = ?, KeSach = ?, TinhTrang = ?, GhiChu = ? " +
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenTL);
            ps.setString(2, namXB);
            ps.setString(3, keSach);
            ps.setString(4, tinhTrang);
            ps.setString(5, ghiChu);
            ps.setString(6, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    */
    public static String searchMaNXB(String maTL){
        String maNXB = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaNXB FROM TaiLieu " + 
                         "WHERE MaTL = " + "'" + maTL + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                maNXB = rs.getString("MaNXB");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maNXB;
    }
    
    public static String searchMaTG(String maTL){
        String maTG = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaTG FROM TaiLieu " + 
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                maTG = rs.getString("MaTG");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maTG;
    }
    
    public static DefaultTableModel dislaySach(){
        DefaultTableModel model = null;
        try {
                Connection con = DataBaseConnection.getConnection();
                String sql = "SELECT MaTL, TenTL, MaKhoa, MaTG, SoLuong, ConLai FROM TaiLieu";
                PreparedStatement ps = con.prepareStatement(sql);
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
        return model;
    }
    
    public static void update(String id, String tenTL, String namXB, int soLuong, int conLai, String keSach, String tinhTrang, String ghiChu){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TaiLieu SET TenTL = ?, NamXB = ?, soLuong = ?, conLai = ?, KeSach = ?, TinhTrang = ?, GhiChu = ? " +
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenTL);
            ps.setString(2, namXB);
            ps.setInt(3, soLuong);
            ps.setInt(4, conLai);
            ps.setString(5, keSach);
            ps.setString(6, tinhTrang);
            ps.setString(7, ghiChu);
            ps.setString(8, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static int searchSoLuong(String maTL){
        int soLuong = 0;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT SoLuong FROM TaiLieu " + 
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                soLuong = rs.getInt("SoLuong");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return soLuong;
    }
    
    public static int searchConLai(String maTL){
        int conLai = 0;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT ConLai FROM TaiLieu " + 
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                conLai = rs.getInt("ConLai");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return conLai;
    }
    
    public static String searchMaKhoa(String maTL){
        String maKhoa = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaKhoa FROM TaiLieu " + 
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                maKhoa = rs.getString("MaKhoa");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maKhoa;
    }
    
    public static String searchTenTL(String maTL){
        String tenTL = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenTL FROM TaiLieu " + 
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tenTL = rs.getString("TenTL");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenTL;
    }

    public ArrayList<TaiLieu> getlistTLTL(){
        ArrayList<TaiLieu> list = new ArrayList<>();
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT * FROM TaiLieu " + 
                         "WHERE TinhTrang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Thanh lý");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiLieu a = new TaiLieu(rs.getString("MaTL"), rs.getString("TenTL"),rs.getString("MaKhoa") , rs.getString("MaNXB"), rs.getString("NamXB"),rs.getString("MaTG") , rs.getInt("SoLuong"), rs.getInt("ConLai"), rs.getString("KeSach"), rs.getString("TinhTrang"), rs.getString("GhiChu"), rs.getString("status"));
                list.add(a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean updateThanhLy(String s){
        try ( Connection c = DataBaseConnection.getConnection()) {
            String del = String.format("update tailieu set TinhTrang = 'da thanh ly' where MaTL ='%s';",s);
            PreparedStatement ps = c.prepareStatement(del);
            int row = ps.executeUpdate(del);//ap dung cho insert update delete;
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public ArrayList<TaiLieu> getlistTLDTL(){
        ArrayList<TaiLieu> list = new ArrayList<>();
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT * FROM TaiLieu " + 
                         "WHERE TinhTrang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "da thanh ly");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiLieu a = new TaiLieu(rs.getString("MaTL"), rs.getString("TenTL"),rs.getString("MaKhoa") , rs.getString("MaNXB"), rs.getString("NamXB"),rs.getString("MaTG") , rs.getInt("SoLuong"), rs.getInt("ConLai"), rs.getString("KeSach"), rs.getString("TinhTrang"), rs.getString("GhiChu"), rs.getString("status"));
                list.add(a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    /*
    public static ResultSet searchTaiLieuTL(String s){
        ResultSet rs = null;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaTL, TenTL, MaKhoa, MaTG, MaNXB, SoLuong, status FROM TaiLieu " + 
                         "WHERE TenTL LIKE ? OR MaTL LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            ps.setString(2, s);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    */
    
    public static DefaultTableModel getDSTL(String khoa){
        DefaultTableModel model = null;
        if(khoa == "Tất cả"){
            try {
                Connection con = DataBaseConnection.getConnection();
                String sql = "SELECT MaTL, TenTL, MaKhoa, MaTG, SoLuong, ConLai FROM TaiLieu";
                PreparedStatement ps = con.prepareStatement(sql);
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
                              "WHERE MaKhoa = ?";
                PreparedStatement ps = con.prepareStatement(sql1);
                ps.setString(1, idKhoa);
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
    
    public static void updateSachConLai(String id, int conLai){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TaiLieu SET ConLai = ? " +
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, conLai);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateStatus(String id, String status){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TaiLieu SET status = ? " +
                         "WHERE MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
