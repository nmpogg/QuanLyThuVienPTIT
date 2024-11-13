/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvienptit.ui;

/**
 *
 * @author tai28
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class LoanSlipPanel extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public LoanSlipPanel() {
        setLayout(new BorderLayout());

        // Tạo panel thông tin phiếu mượn
        JPanel loanInfoPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        loanInfoPanel.setBackground(Color.WHITE);
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PHIẾU MƯỢN SÁCH", TitledBorder.CENTER, TitledBorder.TOP);
        Font font = new Font("Arial", Font.BOLD, 18); // Thiết lập kích thước chữ to hơn
        border.setTitleFont(font);
        loanInfoPanel.setBorder(border);

        // Thêm các trường thông tin phiếu mượn
        loanInfoPanel.add(new JLabel("Mã độc giả:"));
        loanInfoPanel.add(new JLabel("8"));
        loanInfoPanel.add(new JLabel("Tên độc giả:"));
        loanInfoPanel.add(new JLabel("demo5 demo5"));
        loanInfoPanel.add(new JLabel("Ngày sinh:"));
        loanInfoPanel.add(new JLabel("03-11-2020"));
        loanInfoPanel.add(new JLabel("Địa chỉ:"));
        loanInfoPanel.add(new JLabel("demo5"));
        loanInfoPanel.add(new JLabel("Số điện thoại:"));
        loanInfoPanel.add(new JLabel("12345"));
        loanInfoPanel.add(new JLabel("Email:"));
        loanInfoPanel.add(new JLabel("demo5@g.com"));
        loanInfoPanel.add(new JLabel("Ngày mượn:"));
        loanInfoPanel.add(new JLabel("06-24-2020"));
        loanInfoPanel.add(new JLabel("Ngày phải trả:"));
        loanInfoPanel.add(new JLabel("07-14-2020"));
        loanInfoPanel.add(new JLabel("Mã phiếu:"));
        loanInfoPanel.add(new JLabel("Pw9ugahhfT"));

        // Tạo bảng thông tin sách đã mượn
        String[] columnNames = {"Mã sách", "Tên sách", "NXB", "Tác giả", "Thể loại", "Trạng thái"};
        Object[][] data = {
            {10, "Ngày em xa tôi", "Văn học", "", "Ngôn tình", "Chưa trả"},
            {12, "Cậu bé của mùa đông", "Kim Đồng", "", "Tiểu thuyết", "Chưa trả"}
        };
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // Tạo panel cho các nút điều khiển
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton deleteButton = new JButton("Xóa");
        JButton detailButton = new JButton("Chi tiết");
        JButton returnButton = new JButton("Trả sách");

        // Thiết lập màu sắc cho các nút
        deleteButton.setBackground(new Color(178, 34, 34)); // màu đỏ
        deleteButton.setForeground(Color.WHITE);
        detailButton.setBackground(new Color(30, 144, 255)); // màu xanh dương
        detailButton.setForeground(Color.WHITE);
        returnButton.setBackground(new Color(34, 139, 34)); // màu xanh lá cây
        returnButton.setForeground(Color.WHITE);

        buttonPanel.add(deleteButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(returnButton);

        // Thêm các bảng điều khiển vào panel chính
        add(loanInfoPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Thêm sự kiện cho các nút
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một hàng để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String bookDetails = "Mã sách: " + tableModel.getValueAt(selectedRow, 0) + "\n" +
                                         "Tên sách: " + tableModel.getValueAt(selectedRow, 1) + "\n" +
                                         "NXB: " + tableModel.getValueAt(selectedRow, 2) + "\n" +
                                         "Tác giả: " + tableModel.getValueAt(selectedRow, 3) + "\n" +
                                         "Thể loại: " + tableModel.getValueAt(selectedRow, 4) + "\n" +
                                         "Trạng thái: " + tableModel.getValueAt(selectedRow, 5);
                    JOptionPane.showMessageDialog(null, bookDetails, "Chi tiết sách", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một hàng để xem chi tiết.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.setValueAt("Đã trả", selectedRow, 5);
                } else {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một hàng để trả sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PHIẾU MƯỢN SÁCH");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new LoanSlipPanel());
        frame.setVisible(true);
    }
}



