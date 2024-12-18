/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlythuvienptit.ui.JP_ChiTietTL;
import quanlythuvienptit.ui.JP_QLS;

/**
 *
 * @author NguyenXuanKhuong
 */
public class QLSListener implements ActionListener {
    private JP_QLS qls;
    
    public QLSListener(JP_QLS qls){
        this.qls = qls;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Thêm")){
            qls.insert();
        }
        else if(s.equals("Xóa")){
            qls.delete();
        }
        else if(s.equals("Tìm kiếm")){
            qls.search();
        }
        else if(s.equals("Làm mới")){
            qls.reset();
        }
        else if(s.equals("deleteSach")){
            qls.deleteSach();
        }
        else if(s.equals("Chi tiết")){
            try {
                qls.dislayChiTietSach();
            } catch (SQLException ex) {
                Logger.getLogger(QLSListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
