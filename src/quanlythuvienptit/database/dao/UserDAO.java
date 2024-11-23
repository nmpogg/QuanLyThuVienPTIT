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
    public static String quyenHan;
    public static ArrayList<NguoiDung> getAllUser(){
        ArrayList<NguoiDung> dsUser = new ArrayList<>();
        String query = "SELECT * FROM NguoiDung";
        
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             System.out.println("Ket noi thanh cong");
            while (rs.next()) {
                NguoiDung x = new NguoiDung(
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"), 
                    rs.getString("gioiTinh"),
                    rs.getString("dienThoai"),
                    rs.getString("email"),
                    rs.getString("quyenHan"),
                    rs.getString("status")
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
    public static boolean isValidUser(String user, String pass){
        String query = "SELECT QuyenHan FROM NguoiDung WHERE Username = ? AND Password = ?";
        try{
            Connection conn = DataBaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                UserDAO.quyenHan = rs.getString("QuyenHan");
                return true;
            }
        }
        catch(ClassNotFoundException | SQLException e){
            return false;
        }
        return false;
    }
    public static boolean addUser(NguoiDung x) {
        String query = "INSERT INTO NguoiDung (Username, Password, HoTen, NgaySinh, gioiTinh, quyenHan, email, DienThoai, NgayTao, status) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setString(10, x.getStatus());
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

    
    public static boolean deleteUser(String username) {
        String sql = "UPDATE NguoiDung SET status = ? WHERE username = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Ngừng Hoạt Động");
            stmt.setString(2, username);

            int updateOK = stmt.executeUpdate();
            return updateOK > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật trạng thái người dùng: " + e.getMessage());
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean updateUser(NguoiDung nguoiDung) {
        String query = "UPDATE NguoiDung SET " +
                       "Username = ?, " +
                       "Password = ?, " +
                       "HoTen = ?, " +
                       "NgaySinh = ?, " +
                       "gioiTinh = ?, " +
                       "email = ?, " +
                       "DienThoai = ?, " +
                       "quyenHan = ?, " +
                       "status = ? " +
                       "WHERE Username = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nguoiDung.getUsername());
            pstmt.setString(2, nguoiDung.getPassword());
            pstmt.setString(3, nguoiDung.getHoTen());
            pstmt.setString(4, nguoiDung.getNgaySinh());
            pstmt.setString(5, nguoiDung.getGioiTinh());
            pstmt.setString(6, nguoiDung.getEmail());
            pstmt.setString(7, nguoiDung.getDienThoai());
            pstmt.setString(8, nguoiDung.getQuyenHan());
            pstmt.setString(9, nguoiDung.getStatus());
            pstmt.setString(10, nguoiDung.getUsername());

            int updateOK = pstmt.executeUpdate();

            return updateOK > 0;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static NguoiDung getUserByUsername(String username) {
        String query = "SELECT * FROM NguoiDung WHERE Username = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new NguoiDung(
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("gioiTinh"),
                    rs.getString("DienThoai"),
                    rs.getString("email"),
                    rs.getString("quyenHan"),
                    rs.getString("status")
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

