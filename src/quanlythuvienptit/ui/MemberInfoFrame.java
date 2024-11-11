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

public class MemberInfoFrame extends JFrame {

    public MemberInfoFrame() {
        // Thiết lập tiêu đề và kích thước cho JFrame
        setTitle("Member ID");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel chính chứa các thành phần
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel tiêu đề với ngày tháng
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel dateLabel = new JLabel("demo");
        headerPanel.add(dateLabel);

        // Panel chứa thông tin thành viên
        JPanel memberInfoPanel = new JPanel();
        memberInfoPanel.setLayout(new GridLayout(3, 1));

        // Tạo tiêu đề Member ID
        JLabel titleLabel = new JLabel("Member ID", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(211, 211, 211)); // Màu xám nhạt

        // Panel chứa thông tin chi tiết thành viên
        JPanel infoPanel = new JPanel(new GridLayout(4, 4));
        infoPanel.setBackground(new Color(211, 211, 211));
        infoPanel.setForeground(Color.WHITE);

        JLabel lblId = new JLabel("ID : demo");
        JLabel lblHo = new JLabel("Họ : demo");
        JLabel lblTen = new JLabel("Tên : demo");
        JLabel lblGioiTinh = new JLabel("Giới tính : demo");
        JLabel lblNgaySinh = new JLabel("Ngày sinh : yyyy/mm/dd");
        JLabel lblSoDienThoai = new JLabel("Số điện thoại : demo");
        JLabel lblEmail = new JLabel("Email : demo@gmail.com");
        JLabel lblDiaChi = new JLabel("Địa chỉ : demo");

        // Đặt màu chữ cho các JLabel
        for (Component comp : infoPanel.getComponents()) {
        if (comp instanceof JLabel label) {
        String text = label.getText();
        
        // Kiểm tra nếu nội dung là các tiêu đề cần đổi màu
        if (text.startsWith("ID :") || text.startsWith("Họ :") || text.startsWith("Tên :") ||
            text.startsWith("Giới tính :") || text.startsWith("Ngày sinh :") || 
            text.startsWith("Số điện thoại :") || text.startsWith("Email :") || 
            text.startsWith("Địa chỉ :")) {
            label.setForeground(Color.BLUE); // Đổi màu thành xanh
        } else {
            label.setForeground(Color.BLACK); // Nội dung phía sau giữ màu đen
        }
    }
}


        // Thêm các JLabel vào infoPanel
        infoPanel.add(lblHo);
        infoPanel.add(lblTen);
        infoPanel.add(lblGioiTinh);
        infoPanel.add(lblNgaySinh);
        infoPanel.add(lblSoDienThoai);
        infoPanel.add(lblEmail);
        infoPanel.add(lblDiaChi);
        infoPanel.add(lblId);

        // Panel chứa ảnh avatar
        JPanel avatarPanel = new JPanel();
        avatarPanel.setBackground(new Color(230, 230, 230));
        JLabel avatarLabel = new JLabel();
        avatarLabel.setIcon(new ImageIcon("D:\\Dowloads\\sách.jpg")); // Đường dẫn ảnh avatar
        avatarPanel.add(avatarLabel);

        // Panel kết hợp infoPanel và avatarPanel
        JPanel topInfoPanel = new JPanel(new BorderLayout());
        topInfoPanel.add(avatarPanel, BorderLayout.WEST);
        topInfoPanel.add(infoPanel, BorderLayout.CENTER);

        // Panel hiển thị chữ "Libra Master"
        JPanel footerPanel = new JPanel();
        JLabel footerLabel = new JLabel("Libra master");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        footerPanel.setBackground(new Color(0, 0, 139));

        // Bảng hiển thị thông tin sách
        String[] columnNames = {"Mã phiếu", "Mã sách", "Tên sách", "Ngày mượn", "Ngày phải trả", "Trạng thái"};
        Object[][] data = {
                
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm các thành phần vào mainPanel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(titleLabel, BorderLayout.CENTER);
        mainPanel.add(topInfoPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Thêm mainPanel và bảng vào JFrame
        add(mainPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MemberInfoFrame frame = new MemberInfoFrame();
            frame.setVisible(true);
        });
    }
}

