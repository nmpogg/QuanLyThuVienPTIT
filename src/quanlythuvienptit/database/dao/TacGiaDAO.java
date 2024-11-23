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
import quanlythuvienptit.models.TacGia;
/**
 *
 * @author Admin
 */
public class TacGiaDAO {
    public ArrayList<TacGia> getListTG(){
            ArrayList<TacGia> list = new ArrayList<>();
            String sql = "select MaTG,TenTG,GhiChu,GioiTinh,NamSinh,NgayTao from tacgia ORDER BY MaTG ASC";
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
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean delTG(String s) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String del = String.format("delete from tacgia where MaTG ='%s';",s);
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
            String insert = String.format("insert into tacgia (MaTG,TenTG,GhiChu,GioiTinh,NamSinh,NgayTao) values ('%s', '%s', '%s', '%s', '%s', '%s');",tg.getMaTG(),tg.getTenTG(),tg.getGhiChu(),tg.getGioitinh(),tg.getNamSinh(),tg.getNgayTao());
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
}
