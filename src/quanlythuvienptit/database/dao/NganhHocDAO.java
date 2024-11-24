/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database.dao;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlythuvienptit.database.DataBaseConnection;
import quanlythuvienptit.models.NganhHoc;
public class NganhHocDAO {
    public ArrayList<NganhHoc> getListNganhHoc(String maKhoa){
        ArrayList<NganhHoc> list = new ArrayList<>();
        String sql = String.format("select MaNganh,TenNganh,MaKhoa from nganhhoc where MaKhoa = '%s'", maKhoa);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    NganhHoc a = new NganhHoc();
                    a.setMaKhoa(rs.getString("MaKhoa"));
                    a.setTenNganhHoc(rs.getString("TenNganh"));
                    a.setMaNganhHoc(rs.getString("MaNganh"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    
    public static String searchTenNganh(String maNganh){
        String tenNganh = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT tenNganh FROM NganhHoc " + 
                         "WHERE MaNganh = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNganh);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tenNganh = rs.getString("TenNganh");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenNganh;
    }
    
    public static void updateTenNganh(String id, String tenNganh){
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "UPDATE NganhHoc SET TenNganh = ?" +
                         "WHERE MaNganh = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenNganh);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
