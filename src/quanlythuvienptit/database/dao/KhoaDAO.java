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
public class KhoaDAO {
    
    public static ArrayList<String> getTenKhoa() {
        ArrayList<String> dsTenKhoa = new ArrayList<>();
        dsTenKhoa.add("none");
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
}
