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
    
    public ArrayList<String> getTenTG() {
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
    
    public String searchMaTG(String tenTG){
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
}
