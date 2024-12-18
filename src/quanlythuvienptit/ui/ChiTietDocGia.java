/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlythuvienptit.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import quanlythuvienptit.database.dao.DocGiaDAO;
import quanlythuvienptit.database.dao.KhoaDAO;
import quanlythuvienptit.database.dao.LopDAO;
import quanlythuvienptit.database.dao.NganhHocDAO;
import quanlythuvienptit.database.dao.UserDAO;
import quanlythuvienptit.models.DocGia;
import quanlythuvienptit.models.Khoa;
import quanlythuvienptit.models.Lop;
import quanlythuvienptit.models.NganhHoc;

/**
 *
 * @author Admin
 */
public class ChiTietDocGia extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietDocGia
     */
    private DocGia a;
    public ChiTietDocGia(String s) {
        a = new DocGiaDAO().DG(s);
        
        initComponents();
        Ten.setEditable(false);  
        NgaySinh.setEnabled(false);
        GioiTinh.setEnabled(false);
        MaKhoa.setEnabled(false);
        MaNganh.setEnabled(false);
        MaLop.setEnabled(false);
        GhiChu.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MaDG = new javax.swing.JLabel();
        Ten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        GioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MaKhoa = new javax.swing.JComboBox<>();
        MaNganh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NguoiCN = new javax.swing.JLabel();
        MaLop = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NgayCN = new javax.swing.JLabel();
        GhiChu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TrangThai = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT ĐỌC GIẢ");
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Đọc Giả:");

        MaDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaDG.setText(a.getMaDG());

        Ten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Ten.setText(a.getHoTen());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên Đọc Giả:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh:");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try{
            Date date = formatter.parse(a.getNgaySinh());
            NgaySinh.setDate(date);
        }
        catch(ParseException e){
            System.out.println("Lỗi định dạng: " + e.getMessage());
        }
        NgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        GioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        GioiTinh.setSelectedItem(a.getGioTinh());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới Tính:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Khoa:");

        ArrayList<Khoa> listKhoa = new KhoaDAO().getListKhoa();
        String[] stringArray = listKhoa.stream().map(Khoa::toString).toArray(String[]::new);
        MaKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(stringArray));
        for(Khoa b: listKhoa){
            if(b.getMaKhoa().equals(a.getMaKhoa())){
                MaKhoa.setSelectedItem(b.getTenKhoa());
                break;
            }
        }
        MaKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaKhoaActionPerformed(evt);
            }
        });

        ArrayList<NganhHoc> listNganhHoc  = new NganhHocDAO().getListNganhHoc(a.getMaKhoa());
        String[] stringArray1 = listNganhHoc.stream().map(NganhHoc::toString).toArray(String[]::new);
        MaNganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaNganh.setModel(new javax.swing.DefaultComboBoxModel<>(stringArray1));
        for(NganhHoc b: listNganhHoc){
            if(b.getMaNganhHoc().equals(a.getMaNganh())){
                MaNganh.setSelectedItem(b.getTenNganhHoc());
                break;
            }
        }
        MaNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNganhActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngành học:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Lớp:");

        NguoiCN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NguoiCN.setText(a.getNguoiCN());

        ArrayList<Lop> listLop  = new LopDAO().getListLop(a.getMaNganh());
        String[] stringArray2 = listLop.stream().map(Lop::toString).toArray(String[]::new);
        MaLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaLop.setModel(new javax.swing.DefaultComboBoxModel<>(stringArray2));
        for(Lop b: listLop){
            if(b.getMaLop().equals(a.getMaLop())){
                MaLop.setSelectedItem(b.getTenLop());
                break;
            }
        }
        MaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaLopActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Người Cập Nhật:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ngày Cập Nhật:");

        NgayCN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NgayCN.setText(a.getNgayCN());

        GhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GhiChu.setText(a.getGhiChu());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Ghi Chú:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Trạng thái:");

        TrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TrangThai.setText(a.getStatus());

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Access");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Cập Nhật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ten)
                    .addComponent(MaDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaNganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NguoiCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NgayCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MaDG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(MaNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(MaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(NguoiCN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(NgayCN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel16)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Khoa> listKhoa = new KhoaDAO().getListKhoa();
        String khoa = (String)MaKhoa.getSelectedItem();
        String maKhoa = "";
        for(Khoa b : listKhoa){
            if(b.getTenKhoa().equals(khoa)){ 
                maKhoa += b.getMaKhoa();
                break;
            }
        }
        ArrayList<NganhHoc> listNH = new NganhHocDAO().getListNganhHoc();
        
        String nganh = (String)MaNganh.getSelectedItem();
        String maNH = "";
        for(NganhHoc b : listNH){
            if(b.getTenNganhHoc().equals(nganh)){ 
                maNH += b.getMaNganhHoc();
                break;
            }
        }
        ArrayList<Lop> listLop = new LopDAO().getListLop(maNH);
        
        String lop = (String)MaLop.getSelectedItem();
        String maLop = "";
        for(Lop b : listLop){
            if(b.getTenLop().equals(lop)){ 
                maLop += b.getMaLop();
                break;
            }
        }
        DocGia b = new DocGia();
        b.setMaDG(MaDG.getText());
        b.setHoTen(Ten.getText());
        b.setGioTinh((String)GioiTinh.getSelectedItem());
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        b.setNgaySinh(formatter1.format(NgaySinh.getDate()));
        b.setGhiChu(GhiChu.getText());
        b.setMaKhoa(maKhoa);
        b.setMaNganh(maNH);
        b.setMaLop(maLop);
        b.setNguoiCN(UserDAO.TenUser);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = currentDateTime.format(formatter);
        b.setNgayCN(formattedDateTime);
        boolean update = DocGiaDAO.updateDG(b);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Ten.setEditable(true);  
        NgaySinh.setEnabled(true);
        GioiTinh.setEnabled(true);
        MaKhoa.setEnabled(true);
        MaNganh.setEnabled(true);
        MaLop.setEnabled(true);
        GhiChu.setEditable(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MaNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNganhActionPerformed
        ArrayList<NganhHoc> listNH = new NganhHocDAO().getListNganhHoc();
        
        String nganh = (String)MaNganh.getSelectedItem();
        String maNH = "";
        for(NganhHoc b : listNH){
            if(b.getTenNganhHoc().equals(nganh)){ 
                maNH += b.getMaNganhHoc();
                break;
            }
        }
        ArrayList<Lop> listLop  = new LopDAO().getListLop(maNH);
        MaLop.removeAllItems();
        MaLop.addItem("Chọn lớp");
        for(Lop b : listLop){
            MaLop.addItem(b.getTenLop());
        }
    }//GEN-LAST:event_MaNganhActionPerformed

    private void MaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaLopActionPerformed
        
    }//GEN-LAST:event_MaLopActionPerformed

    private void MaKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhoaActionPerformed
        ArrayList<Khoa> listKhoa = new KhoaDAO().getListKhoa();
        String khoa = (String)MaKhoa.getSelectedItem();
        String maKhoa = "";
        for(Khoa b : listKhoa){
            if(b.getTenKhoa().equals(khoa)){ 
                maKhoa += b.getMaKhoa();
                break;
            }
        }
        ArrayList<NganhHoc> listNganhHoc  = new NganhHocDAO().getListNganhHoc(maKhoa);
        MaNganh.removeAllItems();
        MaNganh.addItem("Chọn ngành học");
        for(NganhHoc b : listNganhHoc){
            MaNganh.addItem(b.getTenNganhHoc());
        }
    }//GEN-LAST:event_MaKhoaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChiTietDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChiTietDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChiTietDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChiTietDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChiTietDocGia().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GhiChu;
    private javax.swing.JComboBox<String> GioiTinh;
    private javax.swing.JLabel MaDG;
    private javax.swing.JComboBox<String> MaKhoa;
    private javax.swing.JComboBox<String> MaLop;
    private javax.swing.JComboBox<String> MaNganh;
    private javax.swing.JLabel NgayCN;
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JLabel NguoiCN;
    private javax.swing.JTextField Ten;
    private javax.swing.JLabel TrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
