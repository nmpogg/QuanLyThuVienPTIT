/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlythuvienptit.database.DataBaseConnection;
import quanlythuvienptit.models.TacGia;
/**
 *
 * @author Admin
 */
public class TacGiaDAO {
    public ArrayList<TacGia> getListTG(){
            ArrayList<TacGia> list = new ArrayList<>();
            String sql = "select MaTG,TenTG,GhiChu,GioiTinh,NamSinh,NgayTao,status from tacgia ORDER BY MaTG ASC";
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    TacGia a = new TacGia();
                    a.setMaTG(rs.getString("MaTG"));
                    a.setTenTG(rs.getString("TenTG"));
                    a.setGhiChu(rs.getString("GhiChu"));
                    a.setGioitinh(rs.getString("GioiTinh"));
                    a.setNamSinh(rs.getString("NamSinh"));
                    a.setNgayTao(rs.getString("NgayTao"));
                    a.setStatus(rs.getString("status"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean delTG(String s) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String del = String.format("update tacgia set status = 'không hoạt động' where MaTG ='%s';",s);
            PreparedStatement ps = c.prepareStatement(del);
            int row = ps.executeUpdate(del);//ap dung cho insert update delete;
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public ArrayList<TacGia> getListtenTG(String s){
            ArrayList<TacGia> list = new ArrayList<>();
            String sql = String.format("select MaTG,TenTG,GioiTinh,NamSinh from tacgia where TenTG = '%s' OR MaTG = '%s';",s,s);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    TacGia a = new TacGia();
                    a.setMaTG(rs.getString("MaTG"));
                    a.setTenTG(rs.getString("TenTG"));
                    a.setGioitinh(rs.getString("GioiTinh"));
                    a.setNamSinh(rs.getString("NamSinh"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean insertTacGia(TacGia tg) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String insert = String.format("insert into tacgia (MaTG,TenTG,GhiChu,GioiTinh,NamSinh,NgayTao,status) values ('%s', '%s', '%s', '%s', '%s', '%s','đang hoạt động');",tg.getMaTG(),tg.getTenTG(),tg.getGhiChu(),tg.getGioitinh(),tg.getNamSinh(),tg.getNgayTao());
            PreparedStatement ps = c.prepareStatement(insert);
            int row = ps.executeUpdate(insert);//ap dung cho insert update delete;
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public static boolean isExist(String maTG) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String select = String.format("select * from tacgia where MaTG = '%s'", maTG);//truyen cau lenh truy van trong database
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
    public TacGia TG(String s){
            TacGia a = new TacGia();
            String sql = String.format("select * from tacgia where MaTG = '%s';",s);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    a.setMaTG(s);
                    a.setNamSinh(rs.getString("NamSinh"));
                    a.setGioitinh(rs.getString("GioiTinh"));
                    a.setTenTG(rs.getString("TenTG"));
                    a.setNgayTao(rs.getString("NgayTao"));
                    a.setGhiChu(rs.getString("GhiChu"));
                    a.setStatus(rs.getString("status"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return a;
    }
    public static boolean updateTG(TacGia a) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String insert = String.format("UPDATE tacgia SET TenTG = '%s',GioiTinh = '%s', NamSinh = '%s',GhiChu = '%s' WHERE MaTG = '%s'",a.getTenTG(),a.getGioitinh(),a.getNamSinh(),a.getGhiChu(),a.getMaTG());
            PreparedStatement ps = c.prepareStatement(insert);
            int row = ps.executeUpdate(insert);
            return row >0 ? true:false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    public int maxmatg(){
        int b = 0;
        String sql = "SELECT MAX(MaTG) AS MaxMaTG FROM TacGia;";
        try(Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String a = rs.getString("MaxMaTG");
                b = Integer.parseInt(a.substring(2));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public static ArrayList<String> getTenTG() {
        ArrayList<String> dsTenTG = new ArrayList<>();
        dsTenTG.add("none");
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenTG FROM TacGia";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                dsTenTG.add(rs.getString("TenTG"));     
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsTenTG;
    }
    
    public static String searchMaTG(String tenTG){
        String maTG = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaTG FROM TacGia " +
                         "WHERE TenTG = " + "'" + tenTG + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                maTG = rs.getString("MaTG");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maTG;
    }
    
    public static String searchTenTG(String maTG){
        String tenTG = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenTG FROM TacGia " +
                         "WHERE MaTG = " + "'" + maTG + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                tenTG = rs.getString("TenTG");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenTG;
    }
    
    public static String searchNamSinh(String maTG){
        String namSinh = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT NamSinh FROM TacGia " +
                         "WHERE MaTG = " + "'" + maTG + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                namSinh = rs.getString("NamSinh");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return namSinh;
    }
    
    public static void updateTenTG(String id, String tenTG){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TacGia SET TenTG = ?" +
                         "WHERE MaTG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenTG);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateNamSinh(String id, String namSinh){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TacGia SET NamSinh = ?" +
                         "WHERE MaTG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, namSinh);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}    

