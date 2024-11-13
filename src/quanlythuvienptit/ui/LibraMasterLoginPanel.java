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

public class LibraMasterLoginPanel extends JPanel {

    public LibraMasterLoginPanel() {
        setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn giữa

        // Tạo panel đăng nhập
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(0, 0, 0, 200)); // Màu đen với độ mờ
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel titleLabel = new JLabel("Libra Master", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        loginPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // Căn lề trái
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setIcon(new ImageIcon("C:\\Users\\tai28\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-11 015422.png")); // Đặt đường dẫn tới icon email
        loginPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField emailField = new JTextField(15); // Giảm kích thước ô trống
        loginPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST; // Căn lề trái
        JLabel passwordLabel = new JLabel("Mật khẩu :");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setIcon(new ImageIcon("C:\\Users\\tai28\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-11-11 015439.png")); // Đặt đường dẫn tới icon mật khẩu
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JPasswordField passwordField = new JPasswordField(15); // Giảm kích thước ô trống
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Đăng nhập");
        loginPanel.add(loginButton, gbc);

        gbc.gridy = 4;
        JLabel forgotPasswordLabel = new JLabel("Quên mật khẩu?", JLabel.CENTER);
        forgotPasswordLabel.setForeground(Color.WHITE);
        loginPanel.add(forgotPasswordLabel, gbc);

        // Sử dụng GridBagConstraints để căn giữa
        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.insets = new Insets(10, 10, 10, 10);
        add(loginPanel, outerGbc);

        // Áp dụng ảnh nền
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon backgroundImage = new ImageIcon("D:\\Dowloads\\thu vien.jpg"); // Đường dẫn tới ảnh nền
        Image image = backgroundImage.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Libra Master Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Giảm kích thước của khung
        LibraMasterLoginPanel loginPanel = new LibraMasterLoginPanel();
        frame.add(loginPanel);
        frame.setVisible(true);
    }
}


