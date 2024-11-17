/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import quanlythuvienptit.ui.JP_QLPM;

/**
 *
 * @author NguyenXuanKhuong
 */
public class QLPMListener extends MouseAdapter implements ActionListener {
    private JP_QLPM qlpm;
    
    public QLPMListener(JP_QLPM qlpm){
        this.qlpm = qlpm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Tìm kiếm")){
            qlpm.searchSach();
        }
        else if(s.equals("Xoá")){
            qlpm.deleteSach();
        }
        else if(s.equals("Tìm")){
            qlpm.serchPhieu();
        }
    }

    public void mouseClicked(MouseEvent e){
        qlpm.selectSach();
    }
}
