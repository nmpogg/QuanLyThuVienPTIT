/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.models;

/**
 *
 * @author Admin
 */
public class NganhHoc {
    private String maNganhHoc;
    private String tenNganhHoc;
    private String maKhoa;

    public void setMaNganhHoc(String maNganhHoc) {
        this.maNganhHoc = maNganhHoc;
    }

    public void setTenNganhHoc(String tenNganhHoc) {
        this.tenNganhHoc = tenNganhHoc;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaNganhHoc() {
        return maNganhHoc;
    }

    public String getTenNganhHoc() {
        return tenNganhHoc;
    }

    public String getMaKhoa() {
        return maKhoa;
    }
    @Override
    public String toString() {
        return tenNganhHoc; // Biểu diễn đối tượng dưới dạng chuỗi
    }
}
