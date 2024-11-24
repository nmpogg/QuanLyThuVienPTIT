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
import quanlythuvienptit.models.Lop;

public class LopDAO {
     public ArrayList<Lop> getListLop(String maNg){
        ArrayList<Lop> list = new ArrayList<>();
        String sql = String.format("select MaLop,TenLop,MaNganhHoc from lop where MaNganhHoc = '%s'", maNg);
            try(Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Lop a = new Lop();
                    a.setMaLop(rs.getString("MaLop"));
                    a.setTenLop(rs.getString("TenLop"));
                    a.setMaNganhHoc(rs.getString("MaNganhHoc"));
                    list.add(a);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    public static String searchTenLop(String maLop){
        String tenLop = "";
        try{
            Connection con = DataBaseConnection.getConnection();
            String sql = "SELECT tenLop FROM Lop " + 
                         "WHERE MaLop = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maLop);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tenLop = rs.getString("TenLop");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tenLop;
    }
}
