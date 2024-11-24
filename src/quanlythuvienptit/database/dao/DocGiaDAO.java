/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlythuvienptit.database.DataBaseConnection;
import quanlythuvienptit.models.DocGia;
/**
 *
 * @author Admin
 */
public class DocGiaDAO {
    
    public ArrayList<DocGia> getListDG(){
            ArrayList<DocGia> list = new ArrayList<>();
            String sql = "select MaDG,HoTen,NgaySinh,GioiTinh,MaNganh,status from docgia ORDER BY MaDG ASC";
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    DocGia a = new DocGia();
                    a.setMaDG(rs.getString("MaDG"));
                    a.setHoTen(rs.getString("HoTen"));
                    a.setNgaySinh(rs.getString("NgaySinh"));
                    a.setGioTinh(rs.getString("GioiTinh"));
                    a.setMaNganh(rs.getString("MaNganh"));
                    a.setStatus(rs.getString("status"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean delDG(String s) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String del = String.format("update docgia set status = 'khong hoat dong' where MaDG ='%s';",s);
            PreparedStatement ps = c.prepareStatement(del);
            int row = ps.executeUpdate(del);//ap dung cho insert update delete;
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public ArrayList<DocGia> getListMaThe(String s){
            ArrayList<DocGia> list = new ArrayList<>();
            String sql = String.format("select MaDG,HoTen,NgaySinh,GioiTinh,MaNganh from docgia where MaDG = '%s' OR HoTen = '%s';",s,s);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    DocGia a = new DocGia();
                    a.setMaDG(rs.getString("MaDG"));
                    a.setHoTen(rs.getString("HoTen"));
                    a.setNgaySinh(rs.getString("NgaySinh"));
                    a.setGioTinh(rs.getString("GioiTinh"));
                    a.setMaNganh(rs.getString("MaNganh"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean insertDocGia(DocGia dg) { 
        try ( Connection c = DataBaseConnection.getConnection()) {
            String insert = String.format("insert into docgia (MaDG, HoTen, NgaySinh, GioiTinh, MaNganh, MaKhoa, MaLop, NguoiCN, NgayCN,status) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','dang hoat dong');",dg.getMaDG(),dg.getHoTen(),dg.getNgaySinh(),dg.getGioTinh(),dg.getMaNganh(),dg.getMaKhoa(),dg.getMaLop(),dg.getNguoiCN(),dg.getNgayCN());
            PreparedStatement ps = c.prepareStatement(insert);
            int row = ps.executeUpdate(insert);//ap dung cho insert update delete;
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public static boolean isExist(String soThe) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String select = String.format("select * from docgia where MaDG = '%s'", soThe);//truyen cau lenh truy van trong database
            PreparedStatement ps = c.prepareStatement(select);
            ResultSet rs = ps.executeQuery();//ket qua tra ve rs
            if(rs.next()){
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public int maxmadg(){
        int b = 0;
        String sql = "SELECT MAX(MaDG) AS MaxMaDG FROM DocGia;";
        try(Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String a = rs.getString("MaxMaDG");
                b = Integer.parseInt(a.substring(2));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public DocGia DG(String selectedMaDG) {
        DocGia a = new DocGia();
            String sql = String.format("select * from docgia where MaDG = '%s';",selectedMaDG);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    a.setMaDG(selectedMaDG);
                    a.setNgaySinh(rs.getString("NgaySinh"));
                    a.setGioTinh(rs.getString("GioiTinh"));
                    a.setHoTen(rs.getString("HoTen"));
                    a.setNgayCN(rs.getString("NgayCN"));
                    a.setGhiChu(rs.getString("GhiChu"));
                    a.setMaNganh(rs.getString("MaNganh"));
                    a.setMaKhoa(rs.getString("MaKhoa"));
                    a.setMaLop(rs.getString("MaLop"));
                    a.setNguoiCN(rs.getString("NguoiCN"));
                    a.setStatus(rs.getString("status"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return a;
    }
    public static boolean updateDG(DocGia a) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String insert = String.format("UPDATE docgia SET HoTen = '%s',GioiTinh = '%s', NgaySinh = '%s',GhiChu = '%s',MaNganh ='%s',MaKhoa='%s',MaLop = '%s',status = '%s',NguoiCN = '%s',NgayCN = '%s' WHERE MaDG = '%s'",a.getHoTen(),a.getGioTinh(),a.getNgaySinh(),a.getGhiChu(),a.getMaNganh(),a.getMaKhoa(),a.getMaLop(),a.getStatus(),a.getNguoiCN(),a.getNgayCN(),a.getMaDG());
            PreparedStatement ps = c.prepareStatement(insert);
            int row = ps.executeUpdate(insert);
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public static String getTenDG(String s){
        String tenDG = "";
        try {
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT HoTen FROM DocGia " +
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tenDG = rs.getString("HoTen");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        return tenDG;
    }
    
    public static String searchMaLop(String maDG){
        String maLop = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaLop FROM DocGia " + 
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                maLop = rs.getString("MaLop");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maLop;
    }
    
    public static String searchMaNganh(String maDG){
        String maNganh = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaNganh FROM DocGia " + 
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                maNganh = rs.getString("MaNganh");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maNganh;
    }
    
    public static void updatetenDG(String id, String tenDG){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE DocGia SET HoTen = ?" +
                         "WHERE MaDG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenDG);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}   

