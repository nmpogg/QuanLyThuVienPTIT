/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

import quanlythuvienptit.database.DataBaseConnection;
import java.sql.*;
/**
 *
 * @author NguyenXuanKhuong
 */
public class DocGiaDAO {
    
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
}
