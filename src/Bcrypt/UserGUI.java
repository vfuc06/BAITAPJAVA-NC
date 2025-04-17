package Bcrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class UserGUI {

    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JTextField nameField, classField, studentIdField, usernameField, loginUsernameField;
    private JPasswordField passwordField, loginPasswordField;
    private JTable userTable; // Bảng để hiển thị danh sách người dùng
    private DefaultTableModel tableModel; // Mô hình bảng chứa dữ liệu người dùng

    public UserGUI() {
        frame = new JFrame("Ứng Dụng Đăng Ký / Đăng Nhập");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane, BorderLayout.CENTER);

        createRegisterTab();
        createLoginTab();
        createTableTab();  // Thêm tab bảng hiển thị người dùng

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton viewUsersButton = new JButton("Xem danh sách người dùng");
        viewUsersButton.addActionListener(e -> UserManager.displayUsers(tableModel)); // Hiển thị danh sách người dùng
        buttonPanel.add(viewUsersButton);

        JButton clearDataButton = new JButton("Xóa toàn bộ dữ liệu");
        clearDataButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn xóa toàn bộ dữ liệu?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                UserManager.clearXMLData();
            }
        });
        buttonPanel.add(clearDataButton);

        JButton resetButton = new JButton("Reset ");
        resetButton.addActionListener(e -> resetForm());
        buttonPanel.add(resetButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void createRegisterTab() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Tên:");
        nameField = new JTextField(20);
        JLabel classLabel = new JLabel("Lớp:");
        classField = new JTextField(20);
        JLabel studentIdLabel = new JLabel("Mã số sinh viên:");
        studentIdField = new JTextField(20);
        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordField = new JPasswordField(20);

        JButton registerButton = new JButton("Đăng ký");
        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String className = classField.getText();
            String studentId = studentIdField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || className.isEmpty() || studentId.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin.");
            } else {
                String hashedPassword = UserManager.hashPassword(password);
                UserManager.saveUserToXML(name, className, studentId, username, hashedPassword);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(classLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(classField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(studentIdLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(studentIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        registerPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        registerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        registerPanel.add(registerButton, gbc);

        tabbedPane.addTab("Đăng ký", registerPanel);
    }

    private void createLoginTab() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel loginUsernameLabel = new JLabel("Tên đăng nhập:");
        loginUsernameField = new JTextField(20);
        JLabel loginPasswordLabel = new JLabel("Mật khẩu:");
        loginPasswordField = new JPasswordField(20);

        JButton loginButton = new JButton("Đăng nhập");
        loginButton.addActionListener(e -> {
            String username = loginUsernameField.getText();
            String password = new String(loginPasswordField.getPassword());

            if (UserManager.loginUser(username, password)) {

            } else {
                JOptionPane.showMessageDialog(frame, "Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(loginUsernameLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(loginUsernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(loginPasswordLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(loginPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        tabbedPane.addTab("Đăng nhập", loginPanel);
    }

    private void createTableTab() {

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        String[] columns = {"Tên", "Lớp", "Mã số sinh viên", "Tên đăng nhập"};
        tableModel = new DefaultTableModel(columns, 0);
        userTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(userTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Danh sách người dùng", tablePanel);
    }

    private void resetForm() {
        nameField.setText("");
        classField.setText("");
        studentIdField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        loginUsernameField.setText("");
        loginPasswordField.setText("");
    }

    public static void main(String[] args) {
        new UserGUI();
    }
}
