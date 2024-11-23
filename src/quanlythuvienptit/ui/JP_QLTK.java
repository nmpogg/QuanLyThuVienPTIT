/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlythuvienptit.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import quanlythuvienptit.database.dao.UserDAO;
import quanlythuvienptit.models.NguoiDung;

/**
 *
 * @author admin
 */
public class JP_QLTK extends javax.swing.JPanel {

    /**
     * Creates new form JP_QLTK
     */
    public static NguoiDung user;
    public JP_QLTK() {
        initComponents();
        init();
    }
    
    private void init() {
        set_header(jScrollPane1, bang);
    }
    
    private void set_header(JScrollPane jScrollPane, JTable jTable) {
        jScrollPane.getViewport().setBackground(Color.WHITE);

        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(100, 40)); // Tăng kích thước chiều cao header
        header.setFont(new Font("Arial", Font.PLAIN, 14)); // Thay đổi font chữ
        header.setBackground(Color.RED); // Đặt màu nền
        jTable.setTableHeader(header);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        xoas = new javax.swing.JButton();
        textSearchField = new javax.swing.JTextField();
        find = new javax.swing.JButton();
        filter = new javax.swing.JComboBox<>();
        refresh = new javax.swing.JButton();
        chitiet = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        hoTenField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        soDienThoaiField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        gioiTinhField = new javax.swing.JComboBox<>();
        quyenHanField = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        birthdayField = new com.toedter.calendar.JDateChooser();

        jTabbedPane2.setBackground(new java.awt.Color(255, 102, 102));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane2.setOpaque(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        xoas.setBackground(new java.awt.Color(153, 255, 255));
        xoas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        xoas.setText("Xóa");
        xoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoasActionPerformed(evt);
            }
        });

        textSearchField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        find.setBackground(new java.awt.Color(153, 255, 255));
        find.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        find.setText("Tìm kiếm");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        filter.setBackground(new java.awt.Color(153, 255, 255));
        filter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Admin", "Thủ thư" }));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(153, 255, 255));
        refresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        refresh.setText("Làm mới");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        chitiet.setBackground(new java.awt.Color(153, 255, 255));
        chitiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chitiet.setText("Chi tiết");
        chitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(textSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(find))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(chitiet)
                        .addGap(111, 111, 111)
                        .addComponent(xoas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoas)
                    .addComponent(filter)
                    .addComponent(chitiet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(find)
                        .addComponent(textSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refresh))
                .addGap(22, 22, 22))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        bang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ tên", "Quyền hạn", "Tài khoản", "Ngày sinh", "Số điện thoại", "Trạng thái"
            }
        ));
        bang.setGridColor(new java.awt.Color(0, 255, 255));
        bang.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setViewportView(bang);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Quản lý tài khoản", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM MỚI TÀI KHOẢN");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tài khoản:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Họ tên:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Quyền hạn:");

        hoTenField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        soDienThoaiField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        usernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        gioiTinhField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gioiTinhField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Nam", "Nữ" }));

        quyenHanField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quyenHanField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Admin", "Thủ thư" }));

        addButton.setBackground(new java.awt.Color(153, 255, 255));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        delButton.setBackground(new java.awt.Color(153, 255, 255));
        delButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        delButton.setText("Xóa");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(hoTenField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(quyenHanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthdayField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gioiTinhField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soDienThoaiField))
                        .addComponent(delButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(218, 218, 218))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hoTenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(birthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gioiTinhField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(soDienThoaiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(quyenHanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(delButton))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thêm tài khoản", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
//        ArrayList<NguoiDung> dsnd = UserDAO.getAllUser();
//        String fieldFilter = (String) filter.getSelectedItem();
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        int cnt = 1;
//        for(NguoiDung nd : dsnd){
////            if(nd.getQuyenHan().equals(fieldFilter.toLowerCase())){
//                Object[] row = {String.format("%d", cnt++) ,nd.getHoTen(), nd.getQuyenHan(), nd.getUsername(), nd.getNgaySinh(), nd.getDienThoai()};
//                model.addRow(row);
////            }
//        }
    }//GEN-LAST:event_filterActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        ArrayList<NguoiDung> dsnd = UserDAO.getAllUser();
        String fieldFilter = (String) filter.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) bang.getModel();
        model.setRowCount(0);
        int cnt = 1;
        System.out.println(UserDAO.quyenHan);
        for(NguoiDung user : dsnd){
            if(user.getQuyenHan().toLowerCase().equals(fieldFilter.toLowerCase()) || fieldFilter.equals("Tất cả")){
                Object[] row = {String.format("%d", cnt++) ,user.getHoTen(), user.getQuyenHan(), user.getUsername(), user.getNgaySinh(), user.getDienThoai(), user.getStatus()};
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        String searchText = textSearchField.getText();
        ArrayList<NguoiDung> dsnd = UserDAO.getAllUser();
        DefaultTableModel model = (DefaultTableModel) bang.getModel();
        model.setRowCount(0);
        int cnt = 1;
        for(NguoiDung user : dsnd){
            if(user.getHoTen().toLowerCase().contains(searchText.toLowerCase()) || user.getUsername().toLowerCase().contains(searchText.toLowerCase())){
                Object[] row = {String.format("%d", cnt++) ,user.getHoTen(), user.getQuyenHan(), user.getUsername(), user.getNgaySinh(), user.getDienThoai(), user.getStatus()};
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_findActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String username = usernameField.getText();
        String password = passwordField.getText();
        String hoTen = hoTenField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngaySinh = dateFormat.format(birthdayField.getDate());
        String gioiTinh = (String) gioiTinhField.getSelectedItem();
        String sdt = soDienThoaiField.getText();
        String email = emailField.getText();
        String quyenHan = (String) quyenHanField.getSelectedItem();
        NguoiDung user = new NguoiDung(username, password, hoTen, ngaySinh, gioiTinh, sdt, email, quyenHan, "Đang Hoạt Động");
        if(UserDAO.addUser(user)){
            JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);       
        }
        else{
            JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        usernameField.setText("");
        passwordField.setText("");
        hoTenField.setText("");
        birthdayField.removeAll();
        gioiTinhField.setSelectedItem("None");
        soDienThoaiField.setText("");
        emailField.setText("");
        quyenHanField.setSelectedItem("None");
    }//GEN-LAST:event_delButtonActionPerformed

    private void chitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitietActionPerformed
        ArrayList<NguoiDung> dsnd = UserDAO.getAllUser();
        int selectedRow = bang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xem chi tiết!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String taiKhoan = bang.getValueAt(selectedRow, 3).toString();
        this.user = UserDAO.getUserByUsername(taiKhoan);
        JF_ChiTietNguoiDung chiTiet = null;
        try {
            chiTiet = new JF_ChiTietNguoiDung();
        } catch (ParseException ex) {
            Logger.getLogger(JP_QLTK.class.getName()).log(Level.SEVERE, null, ex);
        }
        chiTiet.setVisible(true);
        return;
    }//GEN-LAST:event_chitietActionPerformed

    private void xoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoasActionPerformed
        ArrayList<NguoiDung> dsnd = UserDAO.getAllUser();
        int selectedRow = bang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String taiKhoan = bang.getValueAt(selectedRow, 3).toString();
        if(UserDAO.deleteUser(taiKhoan)){
            JOptionPane.showMessageDialog(null, "Cập nhật trạng thái hoạt động thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            JOptionPane.showMessageDialog(this, "Cập nhật trạng thái hoạt động thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_xoasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable bang;
    private com.toedter.calendar.JDateChooser birthdayField;
    private javax.swing.JButton chitiet;
    private javax.swing.JButton delButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JButton find;
    private javax.swing.JComboBox<String> gioiTinhField;
    private javax.swing.JTextField hoTenField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField passwordField;
    private javax.swing.JComboBox<String> quyenHanField;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField soDienThoaiField;
    private javax.swing.JTextField textSearchField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JButton xoas;
    // End of variables declaration//GEN-END:variables
}
