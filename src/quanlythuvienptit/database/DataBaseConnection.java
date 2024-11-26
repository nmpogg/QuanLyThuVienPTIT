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
    private static final String URL = "jdbc:mysql://localhost:3306/thuvienptit";
    private static final String USER = "root";
    private static final String PASSWORD = "Asus1580@";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connect = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connect successfully!");
        }
        catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return connect;
    }
}