/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author NguyenXuanKhuong
 */
public class TaiLieu {
    private String MaTL, TenTL, MaKhoa, MaNXB;
    private int NamXB;
    private String MaTG;
    private int SoLuong, ConLai;
    private String KeSach, TinhTrang, GhiChu;

    public TaiLieu(String MaTL, String TenTL, String MaKhoa, String MaNXB, int NamXB, String MaTG, int SoLuong, int ConLai, String KeSach, String TinhTrang, String GhiChu) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
        this.MaKhoa = MaKhoa;
        this.MaNXB = MaNXB;
        this.NamXB = NamXB;
        this.MaTG = MaTG;
        this.SoLuong = SoLuong;
        this.ConLai = ConLai;
        this.KeSach = KeSach;
        this.TinhTrang = TinhTrang;
        this.GhiChu = GhiChu;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String MaKhoa) {
        this.MaKhoa = MaKhoa;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public int getNamXB() {
        return NamXB;
    }

    public void setNamXB(int NamXB) {
        this.NamXB = NamXB;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getConLai() {
        return ConLai;
    }

    public void setConLai(int ConLai) {
        this.ConLai = ConLai;
    }

    public String getKeSach() {
        return KeSach;
    }

    public void setKeSach(String KeSach) {
        this.KeSach = KeSach;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
