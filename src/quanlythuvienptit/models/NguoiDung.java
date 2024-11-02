/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NguoiDung {
    private String username;
    private String password;
    private String hoTen;
    private Date ngaySinh;
    private String gioTinh;
    private String chucDanh;
    private String email;
    private String dienThoai;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioTinh() {
        return gioTinh;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public String getEmail() {
        return email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioTinh(String gioTinh) {
        this.gioTinh = gioTinh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public void ThemNguoiDung(){
        
    }
}
