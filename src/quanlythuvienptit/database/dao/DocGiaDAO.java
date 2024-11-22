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
            String sql = "select MaDG,HoTen,NamSinh,GioiTinh,MaNganh from docgia ORDER BY MaDG ASC";
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    DocGia a = new DocGia();
                    a.setSoThe(rs.getString("MaDG"));
                    a.setHoTen(rs.getString("HoTen"));
                    a.setNamSinh(rs.getString("NamSinh"));
                    a.setGioTinh(rs.getString("GioiTinh"));
                    a.setMaNganh(rs.getString("MaNganh"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean delDG(String s) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String del = String.format("delete from docgia where MaDG ='%s';",s);
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
            String sql = String.format("select MaDG,HoTen,NamSinh,GioiTinh,MaNganh from docgia where MaDG = '%s';",s);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    DocGia a = new DocGia();
                    a.setSoThe(rs.getString("MaDG"));
                    a.setHoTen(rs.getString("HoTen"));
                    a.setNamSinh(rs.getString("NamSinh"));
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
            String insert = String.format("insert into docgia (MaDG, HoTen, NamSinh, GioiTinh, MaNganh, MaKhoa, MaLop, NguoiCN, NgayCN) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",dg.getSoThe(),dg.getHoTen(),dg.getNamSinh(),dg.getGioTinh(),dg.getMaNganh(),dg.getMaKhoa(),dg.getMaLop(),dg.getNguoiCN(),dg.getNgayCN());
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
}   
