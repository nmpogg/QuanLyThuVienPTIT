/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        else if(s.equals("Trả sách")){
            qlpm.traSach();
        }
        else if(s.equals("searchNguoiMuon")){
            qlpm.searchNguoiMuon();
        }
        else if(s.equals("Tạo phiếu mượn")){
            qlpm.insertPhieu();
        }
        else if(s.equals("resetPhieu")){
            qlpm.ThongKePhieu();
        }
        else if(s.equals("Chi tiết")){
            try {
                qlpm.dislayChiTietPhieu();
            } catch (SQLException ex) {
                Logger.getLogger(QLPMListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        Object source = e.getSource();
        if(source == qlpm.getTable5()){
            qlpm.selectSach();   
        }
        else if(source == qlpm.getTable8()){
            qlpm.selectSachDaMuon();
            qlpm.getThongTinTraSach();
        }
    }
}
