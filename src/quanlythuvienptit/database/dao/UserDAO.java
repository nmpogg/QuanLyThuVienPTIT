/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlythuvienptit.database.DataBaseConnection;
import quanlythuvienptit.models.NguoiDung;

/**
 *
 * @author Admin
 */
public class UserDAO {
    public ArrayList<NguoiDung> getAllUser(){
        ArrayList<NguoiDung> dsUser = new ArrayList<>();
        String query = "SELECT * FROM NguoiDung";
        
        try (java.sql.Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             System.out.println("Ket noi thanh cong");
            while (rs.next()) {
                NguoiDung x = new NguoiDung(
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("HoTen"),
                    rs.getString("NamSinh"), // Chuyển đổi từ Date sang LocalDate
                    rs.getString("gioiTinh"),
                    rs.getString("quyenHan"),
                    rs.getString("email"),
                    rs.getString("DienThoai"),
                    rs.getDate("NgayTao").toLocalDate() // Chuyển đổi từ Date sang LocalDate
                );
                dsUser.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi that bai");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsUser;
    }
    
    public static boolean addUser(NguoiDung x) {
        String query = "INSERT INTO NguoiDung (Username, Password, HoTen, NamSinh, gioiTinh, quyenHan, email, DienThoai, NgayTao) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, x.getUsername());
            pstmt.setString(2, x.getPassword());
            pstmt.setString(3, x.getHoTen());
            pstmt.setString(4, x.getNgaySinh());
            pstmt.setString(5, x.getGioTinh());
            pstmt.setString(6, x.getQuyenHan());
            pstmt.setString(7, x.getEmail());
            pstmt.setString(8, x.getDienThoai());
            pstmt.setDate(9, java.sql.Date.valueOf(x.getNgayTao()));
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
//    public boolean deleteUser(User x){
//        return true;
//    }
//    
//    public boolean updateUser(User x){
//        return true;
//    }
}
