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
    private String status;

    public NguoiDung(String username, String password, String hoTen, String ngaySinh, String gioiTinh, String dienThoai, String email, String quyenHan, String status) {
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
        this.quyenHan = quyenHan;
        this.ngayTao = LocalDate.now();
        this.status = status;
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

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
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

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    
}
