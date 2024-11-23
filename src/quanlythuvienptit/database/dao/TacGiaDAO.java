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
public class TacGiaDAO {
    
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
            String sql = "UPDATE TacGia SET TenTG = " + "'" + tenTG + "' " +
                         "WHERE MaTG = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateNamSinh(String id, String namSinh){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE TacGia SET NamSinh = " + "'" + namSinh + "' " +
                         "WHERE MaTG = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
