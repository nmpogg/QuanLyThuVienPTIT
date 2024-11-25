/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import quanlythuvienptit.ui.JF_PhieuMuon;

/**
 *
 * @author NguyenXuanKhuong
 */
public class ChiTietPMListener implements ActionListener {
    private JF_PhieuMuon pm;

    public ChiTietPMListener(JF_PhieuMuon pm) {
        this.pm = pm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Cập nhật phiếu")){
            pm.update();
        }
        else if(s.equals("Edit")){
            pm.edit();
        }
        else if(s.equals("Xóa")){
            pm.delete();
        }
        else if(s.equals("Xuất Phiếu")){
            pm.createPDF();
        }
    }
    
}
