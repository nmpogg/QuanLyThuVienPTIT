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
            String sql = "select MaTG,TenTG,GhiChu from tacgia";
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    TacGia a = new TacGia();
                    a.setMaTG(rs.getString("MaTG"));
                    a.setTenTG(rs.getString("TenTG"));
                    a.setGhiChu(rs.getString("GhiChu"));
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
            String sql = String.format("select MaTG,TenTG,GhiChu from tacgia where TenTG = '%s';",s);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    TacGia a = new TacGia();
                    a.setMaTG(rs.getString("MaTG"));
                    a.setTenTG(rs.getString("TenTG"));
                    a.setGhiChu(rs.getString("GhiChu"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static boolean insertTacGia(TacGia tg) { //check trung username
        try ( Connection c = DataBaseConnection.getConnection()) {
            String insert = String.format("insert into tacgia (MaTG,TenTG,GhiChu) values ('%s', '%s', '%s');",tg.getMaTG(),tg.getTenTG(),tg.getGhiChu());
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
}
