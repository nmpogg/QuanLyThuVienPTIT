/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author NguyenXuanKhuong
 */
public class PhieuMuonTra {
    private String ID_MuonTra, MaDG, MaTL, KieuMuon, NgayMuon, NguoiChoMuon, HanTra,
            TrangThaiMuonTra, NguoiNhan, TinhTrangMuon, TinhTrangTra;

    public PhieuMuonTra(String ID_MuonTra, String MaDG, String MaTL, String KieuMuon, String NgayMuon, String NguoiChoMuon, String HanTra, String TrangThaiMuonTra, String NguoiNhan, String TinhTrangMuon, String TinhTrangTra) {
        this.ID_MuonTra = ID_MuonTra;
        this.MaDG = MaDG;
        this.MaTL = MaTL;
        this.KieuMuon = KieuMuon;
        this.NgayMuon = NgayMuon;
        this.NguoiChoMuon = NguoiChoMuon;
        this.HanTra = HanTra;
        this.TrangThaiMuonTra = TrangThaiMuonTra;
        this.NguoiNhan = NguoiNhan;
        this.TinhTrangMuon = TinhTrangMuon;
        this.TinhTrangTra = TinhTrangTra;
    }

    public String getID_MuonTra() {
        return ID_MuonTra;
    }

    public void setID_MuonTra(String ID_MuonTra) {
        this.ID_MuonTra = ID_MuonTra;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getKieuMuon() {
        return KieuMuon;
    }

    public void setKieuMuon(String KieuMuon) {
        this.KieuMuon = KieuMuon;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public String getNguoiChoMuon() {
        return NguoiChoMuon;
    }

    public void setNguoiChoMuon(String NguoiChoMuon) {
        this.NguoiChoMuon = NguoiChoMuon;
    }

    public String getHanTra() {
        return HanTra;
    }

    public void setHanTra(String HanTra) {
        this.HanTra = HanTra;
    }

    public String getTrangThaiMuonTra() {
        return TrangThaiMuonTra;
    }

    public void setTrangThaiMuonTra(String TrangThaiMuonTra) {
        this.TrangThaiMuonTra = TrangThaiMuonTra;
    }

    public String getNguoiNhan() {
        return NguoiNhan;
    }

    public void setNguoiNhan(String NguoiNhan) {
        this.NguoiNhan = NguoiNhan;
    }

    public String getTinhTrangMuon() {
        return TinhTrangMuon;
    }

    public void setTinhTrangMuon(String TinhTrangMuon) {
        this.TinhTrangMuon = TinhTrangMuon;
    }

    public String getTinhTrangTra() {
        return TinhTrangTra;
    }

    public void setTinhTrangTra(String TinhTrangTra) {
        this.TinhTrangTra = TinhTrangTra;
    }
    
    
}
