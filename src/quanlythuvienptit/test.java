/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit;

import javax.swing.JFrame;
import quanlythuvienptit.ui.JP_QLPM;
import quanlythuvienptit.ui.JP_QLS;

/**
 *
 * @author NguyenXuanKhuong
 */
public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản Lý Thư Viện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 720);
        frame.add(new JP_QLPM());
        frame.setVisible(true);
    }
}
