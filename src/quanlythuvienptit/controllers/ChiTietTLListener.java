/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import quanlythuvienptit.ui.JP_ChiTietTL;

/**
 *
 * @author NguyenXuanKhuong
 */
public class ChiTietTLListener implements ActionListener {
    JP_ChiTietTL chiTietTL;

    public ChiTietTLListener(JP_ChiTietTL chiTietTL) {
        this.chiTietTL = chiTietTL;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Cập nhật")){
            chiTietTL.update();
        }
        else if(s.equals("Edit")){
            chiTietTL.edit();
        }
    }
    
}
