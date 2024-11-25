/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author Admin
 */
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private String ghiChu;

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    @Override
    public String toString() {
        return tenKhoa; // Biểu diễn đối tượng dưới dạng chuỗi
    }
    
}
