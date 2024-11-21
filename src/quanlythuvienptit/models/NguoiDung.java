/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

import java.time.LocalDate;


/**
 *
 * @author Admin
 */
public class NguoiDung {
    private String username;
    private String password;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String quyenHan;
    private String email;
    private String dienThoai;
    private LocalDate ngayTao;

    public NguoiDung(String username, String password, String hoTen, String ngaySinh, String gioiTinh, String dienThoai, String email, String quyenHan,  LocalDate ngaytao) {
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quyenHan = quyenHan;
        this.email = email;
        this.dienThoai = dienThoai;
        this.ngayTao = LocalDate.now();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioTinh() {
        return gioiTinh;
    }

    public String getQuyenHan() {
        return quyenHan;
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


    public void setGioTinh(String gioTinh) {
        this.gioiTinh = gioTinh;
    }

    public void setChucDanh(String chucDanh) {
        this.quyenHan = chucDanh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getNgayTao() {
        return this.ngayTao.toString();
    }
    
}
