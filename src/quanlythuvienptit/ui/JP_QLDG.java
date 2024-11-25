/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlythuvienptit.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
 * @author admin
 */
public class JP_QLDG extends javax.swing.JPanel {

    /**
     * Creates new form JP_QLDG
     */
    private ArrayList<DocGia> listDG;
    public static String selectedMaDG;
    private void showdata(){
        listDG = new DocGiaDAO().getListDG();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        int cnt = 1;
        if(!UserDAO.quyenHan.toLowerCase().equals("admin")){
            for(DocGia a : listDG){
                if(!a.getStatus().equals("không hoạt động")) model.addRow(new Object[]{
                    cnt++,a.getMaDG(),a.getHoTen(),a.getNgaySinh(),a.getGioTinh(),a.getTenNganh()
                });
            }
        }
        else{
            for(DocGia a : listDG){
                model.addRow(new Object[]{
                    cnt++,a.getMaDG(),a.getHoTen(),a.getNgaySinh(),a.getGioTinh(),a.getTenNganh()
                });
            }
        }
        
    }
    public JP_QLDG() {
        initComponents();
        showdata();
        init();
    }
    
    private void init() {
        set_header(jScrollPane4, jTable4);
        ArrayList<Khoa> listKhoa = new KhoaDAO().getListKhoa();
        for(Khoa a : listKhoa){
            MaKhoa.addItem(a.getTenKhoa());
        }
        ArrayList<NganhHoc> list = new NganhHocDAO().getListNganhHoc();
        for(NganhHoc a: list){
            Filter.addItem(a.getTenNganhHoc());
        }
        
    }
    
    private void set_header(JScrollPane jScrollPane, JTable jTable) {
        jScrollPane.getViewport().setBackground(Color.WHITE);

        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(100, 40)); // Tăng kích thước chiều cao header
        header.setFont(new Font("Arial", Font.PLAIN, 14)); // Thay đổi font chữ
        header.setBackground(new Color(255, 102, 102)); // Đặt màu nền
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

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jTextField18 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        Filter = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jTextField20 = new javax.swing.JTextField();
        JComboBox = new javax.swing.JComboBox<>();
        MaNganh = new javax.swing.JComboBox<>();
        MaKhoa = new javax.swing.JComboBox<>();
        MaLop = new javax.swing.JComboBox<>();
        NamSinh = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane5.setBackground(new java.awt.Color(255, 102, 102));
        jTabbedPane5.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane5.setOpaque(true);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(153, 255, 255));
        jButton21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton21.setText("Xóa");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(153, 255, 255));
        jButton22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton22.setText("Làm mới");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(153, 255, 255));
        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton23.setText("Chi tiết");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(153, 255, 255));
        jButton24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton24.setText("Tìm kiếm");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc theo ngành học"}));
        Filter.setSelectedItem("Lọc theo ngành học");
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton21)
                        .addGap(39, 39, 39)
                        .addComponent(jButton23)))
                .addGap(64, 64, 64)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton24)
                        .addContainerGap(584, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(jButton22)
                    .addComponent(jButton23)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Đọc Giả", "Họ tên", "Ngày sinh", "Giới tính", "Ngành"
            }
        ));
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Quản lý đọc giả", jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setBackground(new java.awt.Color(255, 102, 102));
        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("THÊM MỚI ĐỌC GIẢ");
        jLabel20.setFocusCycleRoot(true);
        jLabel20.setOpaque(true);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Họ tên:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Năm sinh:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Mã ngành:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Giới tính:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Mã khoa:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Mã lớp:");

        jButton25.setBackground(new java.awt.Color(153, 255, 255));
        jButton25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton25.setText("Thêm mới");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(153, 255, 255));
        jButton26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton26.setText("Xóa");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jTextField20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Nam", "Nữ" }));
        JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxActionPerformed(evt);
            }
        });

        MaNganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Các ngành lấy từ CSDL" }));
        MaNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNganhActionPerformed(evt);
            }
        });

        MaKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Các khoa lấy từ CSDL" }));
        MaKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaKhoaActionPerformed(evt);
            }
        });

        MaLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớp lấy từ CSDL" }));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField20)
                    .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamSinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaNganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton25)
                .addGap(105, 105, 105)
                .addComponent(jButton26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(NamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(MaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(72, 72, 72)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton26))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(484, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Thêm đọc giả", jPanel20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        showdata();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(!UserDAO.quyenHan.toLowerCase().equals("admin")){
            JOptionPane.showMessageDialog(JComboBox, "Bạn không có quyền");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        int removeIndex = jTable4.getSelectedRow();
        if(removeIndex == -1){
            JOptionPane.showMessageDialog(JComboBox, "Hãy chọn một dòng");
        }
        else if(listDG.isEmpty()){
            JOptionPane.showMessageDialog(JComboBox, "Không có thông tin để xóa");
        }
        else{
            String s = listDG.get(removeIndex).getMaDG();
            boolean del = DocGiaDAO.delDG(s);
            showdata();
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String s = jTextField18.getText().toLowerCase();
        if(s.equals("")){
            JOptionPane.showMessageDialog(JComboBox, "Hãy nhập thông tin");
        }
        else{
            listDG = new DocGiaDAO().getListDG();
            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);
            int cnt = 1;
            for(DocGia a : listDG){
                if(a.getMaDG().toLowerCase().contains(s)||a.getHoTen().toLowerCase().contains(s)){
                    model.addRow(new Object[]{
                        cnt++,a.getMaDG(),a.getHoTen(),a.getNgaySinh(),a.getGioTinh(),a.getMaNganh()
                    });
                }
            } 
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        if(!UserDAO.quyenHan.toLowerCase().equals("admin")){
            JOptionPane.showMessageDialog(JComboBox, "Bạn không có quyền");
            return;
        }
        ArrayList<Khoa> listKhoa = new KhoaDAO().getListKhoa();
        String khoa = (String)MaKhoa.getSelectedItem();
        String maKhoa = "";
        for(Khoa a : listKhoa){
            if(a.getTenKhoa().equals(khoa)){ 
                maKhoa += a.getMaKhoa();
                break;
            }
        }
        ArrayList<NganhHoc> listNH = new NganhHocDAO().getListNganhHoc();
        
        String nganh = (String)MaNganh.getSelectedItem();
        String maNH = "";
        for(NganhHoc a : listNH){
            if(a.getTenNganhHoc().equals(nganh)){ 
                maNH += a.getMaNganhHoc();
                break;
            }
        }
        ArrayList<Lop> listLop = new LopDAO().getListLop(maNH);
        
        String lop = (String)MaLop.getSelectedItem();
        String maLop = "";
        for(Lop a : listLop){
            if(a.getTenLop().equals(lop)){ 
                maLop += a.getMaLop();
                break;
            }
        }
        DocGia a = new DocGia();
        int max = new DocGiaDAO().maxmadg();
        String maDG = String.format("DG%03d", max+1);
        a.setMaDG(maDG);
        a.setHoTen(jTextField20.getText());
        a.setGioTinh((String) JComboBox.getSelectedItem());
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        a.setNgaySinh(formatter1.format(NamSinh.getDate()));
        a.setMaNganh(maNH);
        a.setMaKhoa(maKhoa);
        a.setMaLop(maLop);
        a.setNguoiCN(UserDAO.TenUser);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        
        a.setNgayCN(formattedNow);
        
        if(a.getMaDG().equals("")||a.getHoTen().equals("")||a.getNgaySinh().equals("")||a.getGioTinh().equals("None")||a.getMaKhoa().equals("Chọn khoa")||a.getMaNganh().equals("Chọn ngành học")||a.getMaLop().equals("Chọn lớp")||a.getNguoiCN().equals("")||a.getNgayCN().equals("")){
            JOptionPane.showMessageDialog(JComboBox, "Hãy điền đầy đủ thông tin");
            return;
        }
        boolean isExist = DocGiaDAO.isExist(a.getMaDG());
        if(isExist){
            JOptionPane.showMessageDialog(JComboBox, "Mã độc giả đã tồn tại");
        }
        else{
            boolean insert = DocGiaDAO.insertDocGia(a);
            if(!insert){
                JOptionPane.showMessageDialog(JComboBox, "Sever error!");
            }
            else{
                JOptionPane.showMessageDialog(JComboBox, "Thêm độc giả thành công !");
            }
            
        }
        jTextField20.setText("");
        
    }//GEN-LAST:event_jButton25ActionPerformed

    private void JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxActionPerformed
        
    }//GEN-LAST:event_JComboBoxActionPerformed

    private void MaNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNganhActionPerformed
        ArrayList<NganhHoc> listNH = new NganhHocDAO().getListNganhHoc();
        
        String nganh = (String)MaNganh.getSelectedItem();
        String maNH = "";
        for(NganhHoc a : listNH){
            if(a.getTenNganhHoc().equals(nganh)){ 
                maNH += a.getMaNganhHoc();
                break;
            }
        }
        ArrayList<Lop> listLop  = new LopDAO().getListLop(maNH);
        MaLop.removeAllItems();
        MaLop.addItem("Chọn lớp");
        for(Lop a : listLop){
            MaLop.addItem(a.getTenLop());
        }
    }//GEN-LAST:event_MaNganhActionPerformed

    private void MaKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaKhoaActionPerformed
        ArrayList<Khoa> listKhoa = new KhoaDAO().getListKhoa();
        String khoa = (String)MaKhoa.getSelectedItem();
        String maKhoa = "";
        for(Khoa a : listKhoa){
            if(a.getTenKhoa().equals(khoa)){ 
                maKhoa += a.getMaKhoa();
                break;
            }
        }
        ArrayList<NganhHoc> listNganhHoc  = new NganhHocDAO().getListNganhHoc(maKhoa);
        MaNganh.removeAllItems();
        MaNganh.addItem("Chọn ngành học");
        for(NganhHoc a : listNganhHoc){
            MaNganh.addItem(a.getTenNganhHoc());
        }
    }//GEN-LAST:event_MaKhoaActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed

        jTextField20.setText("");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        int selectedRow = jTable4.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(JComboBox, "Hãy chọn một dòng.");
            return;
        }
        selectedMaDG = (String) jTable4.getValueAt(selectedRow, 1);
        ChiTietDocGia a = new ChiTietDocGia(selectedMaDG);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        String s = (String) Filter.getSelectedItem();
        listDG = new DocGiaDAO().getListDG();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        int cnt = 1;
        if(!UserDAO.quyenHan.toLowerCase().equals("admin")){
            for(DocGia a : listDG){
                if(!a.getStatus().equals("không hoạt động"))
                    if(a.getTenNganh().equals(s)) model.addRow(new Object[]{
                    cnt++,a.getMaDG(),a.getHoTen(),a.getNgaySinh(),a.getGioTinh(),a.getTenNganh()
                });
            }
        }
        else{
            for(DocGia a : listDG){
                if(a.getTenNganh().equals(s)) model.addRow(new Object[]{
                    cnt++,a.getMaDG(),a.getHoTen(),a.getNgaySinh(),a.getGioTinh(),a.getTenNganh()
                });
            }
        }
        
        
    }//GEN-LAST:event_FilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JComboBox<String> JComboBox;
    private javax.swing.JComboBox<String> MaKhoa;
    private javax.swing.JComboBox<String> MaLop;
    private javax.swing.JComboBox<String> MaNganh;
    private com.toedter.calendar.JDateChooser NamSinh;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField20;
    // End of variables declaration//GEN-END:variables
}
