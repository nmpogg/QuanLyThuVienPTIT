/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DataBaseConnection {
    private static String DB_URL = "jdbc:mysql://localhost:3306/btloop";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";
    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } 
        catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return connect;
    }
}
