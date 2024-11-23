/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/quanlythuvien?autoReconnect=true&useSSL=false";
    private static String username = "root";
    private static String password = "090204";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return (Connection) DriverManager.getConnection(url, username, password);
    }
}