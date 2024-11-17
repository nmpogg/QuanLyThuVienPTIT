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
        if(s.equals("searchSach")){
            qlpm.searchSach();
        }
        else if(s.equals("deleteSach")){
            qlpm.deleteSach();
        }
        else if(s.equals("Tìm")){
            qlpm.searchPhieu();
        }
        else if(s.equals("resetSach")){
            qlpm.resetSach();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        Object source = e.getSource();
        if(source == qlpm.getTable5()){
            qlpm.selectSach();   
        }
        else if(source == qlpm.getTable8()){
            qlpm.getThongTinTraSach();
        }
    }
}
