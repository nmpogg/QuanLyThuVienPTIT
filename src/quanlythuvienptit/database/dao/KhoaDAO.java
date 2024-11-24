/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

/**
 *
 * @author Admin
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlythuvienptit.database.DataBaseConnection;
import quanlythuvienptit.models.Khoa;
public class KhoaDAO {
    public ArrayList<Khoa> getListKhoa(){
        ArrayList<Khoa> list = new ArrayList<>();
        String sql = "select MaKhoa,TenKhoa from khoa";
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Khoa a = new Khoa();
                    a.setMaKhoa(rs.getString("MaKhoa"));
                    a.setTenKhoa(rs.getString("TenKhoa"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static ArrayList<String> getTenKhoa() {
        ArrayList<String> dsTenKhoa = new ArrayList<>();
        dsTenKhoa.add("Tất cả");
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenKhoa FROM Khoa";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                dsTenKhoa.add(rs.getString("TenKhoa"));     
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsTenKhoa;
    }
    
    public static String searchMaKhoa(String tenKhoa){
        String maKhoa = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaKhoa FROM Khoa " +
                         "WHERE TenKhoa = " + "'" + tenKhoa + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                maKhoa = rs.getString("MaKhoa");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maKhoa;

    }
    public static String searchTenKhoa(String maKhoa){
        String tenKhoa = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenKhoa FROM Khoa " +
                         "WHERE MaKhoa = " + "'" + maKhoa + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                tenKhoa = rs.getString("TenKhoa");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenKhoa;
   }
    
    public static void updateTenKhoa(String id, String tenKhoa){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE Khoa SET TenKhoa = ?" +
                         "WHERE MaKhoa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenKhoa);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

