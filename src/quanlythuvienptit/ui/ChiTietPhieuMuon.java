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
import java.awt.*;

public class ChiTietPhieuMuon extends JFrame {
    public ChiTietPhieuMuon() {
        // Thiết lập JFrame
        setTitle("Chi tiết phiếu mượn");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel tiêu đề
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Chi tiết phiếu mượn", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel maPhieuLabel = new JLabel("Mã phiếu: Pw9ugahfT", JLabel.RIGHT);
        titlePanel.add(titleLabel, BorderLayout.WEST);
        titlePanel.add(maPhieuLabel, BorderLayout.EAST);
        mainPanel.add(titlePanel);

        // Panel Thông tin sách
        JPanel bookInfoPanel = new JPanel();
        bookInfoPanel.setLayout(new BorderLayout());
        bookInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin sách"));
        bookInfoPanel.setPreferredSize(new Dimension(350, 80));

        JTextArea bookInfoText = new JTextArea(
                "Tên sách:   Mã sách: 10\n" +
                "NXB: \n" +
                "Thể loại: \n" +
                "Tác giả:"
        );
        bookInfoText.setEditable(false);
        bookInfoText.setFont(new Font("Arial", Font.PLAIN, 12));
        bookInfoPanel.add(bookInfoText, BorderLayout.CENTER);
        mainPanel.add(bookInfoPanel);

        // Panel Thông tin trả sách
        JPanel returnInfoPanel = new JPanel();
        returnInfoPanel.setLayout(new BorderLayout());
        returnInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin trả sách"));
        returnInfoPanel.setPreferredSize(new Dimension(350, 120));

        // Tiêu đề trạng thái
        JPanel statusPanel = new JPanel(new BorderLayout());
        JLabel statusLabel = new JLabel("Trạng thái: Đã trả", JLabel.RIGHT);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusPanel.add(statusLabel, BorderLayout.EAST);
        returnInfoPanel.add(statusPanel, BorderLayout.NORTH);

        // Nội dung thông tin trả sách
        JPanel returnContentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 2, 5); // Giảm khoảng cách giữa các dòng
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        returnContentPanel.add(new JLabel("Ngày trả:"), gbc);
        gbc.gridx = 1;
        JTextField ngayTraField = new JTextField("");
        ngayTraField.setPreferredSize(new Dimension(100, 20));
        returnContentPanel.add(ngayTraField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        returnContentPanel.add(new JLabel("Số ngày trả muộn:"), gbc);
        gbc.gridx = 1;
        JTextField soNgayTraMuonField = new JTextField("0");
        soNgayTraMuonField.setPreferredSize(new Dimension(100, 20));
        returnContentPanel.add(soNgayTraMuonField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        returnContentPanel.add(new JLabel("Tiền phạt:"), gbc);
        gbc.gridx = 1;
        JTextField tienPhatField = new JTextField("0.0");
        tienPhatField.setPreferredSize(new Dimension(100, 20));
        returnContentPanel.add(tienPhatField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        returnContentPanel.add(new JLabel("Tình trạng sách:"), gbc);
        gbc.gridx = 1;
        JTextArea tinhTrangSachArea = new JTextArea("oke");
        tinhTrangSachArea.setPreferredSize(new Dimension(100, 40));
        returnContentPanel.add(new JScrollPane(tinhTrangSachArea), gbc);

        returnInfoPanel.add(returnContentPanel, BorderLayout.CENTER);
        mainPanel.add(returnInfoPanel);

        // Panel nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton capNhatButton = new JButton("Cập nhật");
        JButton troLaiButton = new JButton("Trở lại");
        buttonPanel.add(capNhatButton);
        buttonPanel.add(troLaiButton);
        mainPanel.add(buttonPanel);

        // Thêm mainPanel vào JFrame
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChiTietPhieuMuon();
    }
}

