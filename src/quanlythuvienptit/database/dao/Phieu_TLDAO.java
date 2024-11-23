/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

import java.sql.*;
import java.util.ArrayList;
import quanlythuvienptit.database.DataBaseConnection;

/**
 *
 * @author NguyenXuanKhuong
 */
public class Phieu_TLDAO {
    
    public static ArrayList<String> getMaTL(String id){
        ArrayList<String> dsMaTL = new ArrayList<>();
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT MaTL FROM Phieu_TaiLieu " + 
                         "WHERE ID_MuonTra = " + "'" + id + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                dsMaTL.add(rs.getString("MaTL"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return dsMaTL;
    }
    
    public static void insertSachMuon(String idPM, String idTL){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "INSERT INTO Phieu_TaiLieu VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idPM);
            ps.setString(2, idTL);
            ps.setString(3, "Chưa trả");
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateTrangThaiMT(String idPM, String idTL){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE Phieu_TaiLieu SET TrangThaiMuonTra = 'Đã trả' " +
                         "WHERE ID_MuonTra = ? AND MaTL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idPM);
            ps.setString(2, idTL);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static int getSoSachMuon(String id){
        int cnt = 0;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT COUNT(ID_MuonTra) AS SoSachMuon FROM Phieu_TaiLieu " + 
                         "WHERE ID_MuonTra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cnt = rs.getInt("SoSachMuon");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cnt;
    }
    
    public static int getSoSachDaTra(String id){
        int cnt = 0;
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT COUNT(ID_MuonTra) AS SoSachDaTra FROM Phieu_TaiLieu " + 
                         "WHERE ID_MuonTra = ? AND TrangThaiMuonTra = 'Đã trả'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cnt = rs.getInt("SoSachDaTra");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cnt;
    }
    
}
