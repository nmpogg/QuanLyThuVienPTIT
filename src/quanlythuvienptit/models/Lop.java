/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author NguyenXuanKhuong
 */
public class Lop {
    private String MaLop, TenLop, MaNganhHoc;

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getMaNganhHoc() {
        return MaNganhHoc;
    }

    public void setMaNganhHoc(String MaNganhHoc) {
        this.MaNganhHoc = MaNganhHoc;
    }
    @Override
    public String toString() {
        return TenLop; // Biểu diễn đối tượng dưới dạng chuỗi
    }
   
    
}
