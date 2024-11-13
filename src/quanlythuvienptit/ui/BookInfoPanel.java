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
import javax.swing.border.TitledBorder;

public class BookInfoPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public BookInfoPanel() {
        setLayout(new BorderLayout());

        // Tạo panel thông tin sách
        JPanel bookInfoPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        bookInfoPanel.setBackground(Color.WHITE); // Đặt màu nền trắng cho panel
        TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "THÔNG TIN SÁCH", TitledBorder.CENTER, TitledBorder.TOP);
        Font font = new Font("Arial", Font.BOLD, 18); // Thiết lập kích thước chữ to hơn
        border.setTitleFont(font);
        bookInfoPanel.setBorder(border);

        // Thêm các trường thông tin sách
        bookInfoPanel.add(createLabel("Tên sách:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("NXB:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("Danh mục:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("Năm xuất bản:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("Số trang:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("Giá sách:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("Trạng thái:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));
        bookInfoPanel.add(createLabel("Số kệ sách:", Color.BLACK));
        bookInfoPanel.add(createLabel("", Color.BLACK));

        // Tạo bảng thông tin tác giả
        String[] columnNames = {"Tác giả", "Vị trí"};
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);

        // Tạo panel tác giả
        JPanel authorPanel = new JPanel(new BorderLayout());
        authorPanel.setBackground(Color.LIGHT_GRAY);
        authorPanel.add(new JLabel("Tác giả:"), BorderLayout.NORTH);
        authorPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Thêm các bảng điều khiển vào panel chính
        add(bookInfoPanel, BorderLayout.NORTH);
        add(authorPanel, BorderLayout.CENTER);
    }

    // Phương thức tạo JLabel với màu nền
    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setForeground(color);
        return label;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("THÔNG TIN SÁCH");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.add(new BookInfoPanel());
        frame.setVisible(true);
    }
}

