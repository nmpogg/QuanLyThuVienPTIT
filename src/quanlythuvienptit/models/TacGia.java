/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author Admin
 */
public class TacGia {
    private String maTG;
    private String tenTG;
    private String ghiChu;
    private String gioitinh;
    private String NamSinh;
    private String NgayTao;

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaTG() {
        return maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
    
}
