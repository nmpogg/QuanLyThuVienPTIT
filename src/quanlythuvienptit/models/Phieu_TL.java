/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author NguyenXuanKhuong
 */
public class Phieu_TL {
    private String ID_MuonTra, MaTL, TrangThaiMuonTra;

    public Phieu_TL(String ID_MuonTra, String MaTL, String TrangThaiMuonTra) {
        this.ID_MuonTra = ID_MuonTra;
        this.MaTL = MaTL;
        this.TrangThaiMuonTra = TrangThaiMuonTra;
    }

    public String getID_MuonTra() {
        return ID_MuonTra;
    }

    public void setID_MuonTra(String ID_MuonTra) {
        this.ID_MuonTra = ID_MuonTra;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTrangThaiMuonTra() {
        return TrangThaiMuonTra;
    }

    public void setTrangThaiMuonTra(String TrangThaiMuonTra) {
        this.TrangThaiMuonTra = TrangThaiMuonTra;
    }
    
    
}
