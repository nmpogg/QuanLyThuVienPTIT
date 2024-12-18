/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

import java.util.ArrayList;
import java.sql.*;
import quanlythuvienptit.database.DataBaseConnection;

/**
 *
 * @author NguyenXuanKhuong
 */
public class NhaXuatBanDAO {
    
    public static ArrayList<String> getTenNXB() {
        ArrayList<String> dsTenNXB = new ArrayList<>();
        dsTenNXB.add("none");
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenNXB FROM NhaXuatBan";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                dsTenNXB.add(rs.getString("TenNXB"));     
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsTenNXB;
    }
    
    public static String searchMaNXB(String tenNXB){
        String maNXB = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaNXB FROM NhaXuatBan " +
                         "WHERE TenNXB = " + "'" + tenNXB + "'";
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
    
    public static String searchTenNXB(String maNXB){
        String tenNXB = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT TenNXB FROM NhaXuatBan " +
                         "WHERE MaNXB = " + "'" + maNXB + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                tenNXB = rs.getString("TenNXB");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenNXB;
    }
    public static void updateTenNXB(String id, String tenNXB){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE NhaXuatBan SET TenNXB = " + "'" + tenNXB + "' " +
                         "WHERE MaNXB = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
