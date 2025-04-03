package TH270325;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class XMLGUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtId, txtTitle, txtAuthor, txtYear;

    public XMLGUI() {
        setTitle("XML Book Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Bảng hiển thị sách
        tableModel = new DefaultTableModel(new Object[]{"ID", "Title", "Author", "Year"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel nhập dữ liệu
        JPanel inputPanel = new JPanel(new GridLayout(2, 4));
        txtId = new JTextField();
        txtTitle = new JTextField();
        txtAuthor = new JTextField();
        txtYear = new JTextField();

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(txtTitle);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(txtAuthor);
        inputPanel.add(new JLabel("Year:"));
        inputPanel.add(txtYear);
        add(inputPanel, BorderLayout.NORTH);

        // Panel nút bấm
        JPanel buttonPanel = new JPanel();
        JButton btnLoad = new JButton("Load");
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");

        btnLoad.addActionListener(this::loadBooks);
        btnAdd.addActionListener(this::addBook);
        btnDelete.addActionListener(this::deleteBook);

        buttonPanel.add(btnLoad);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        loadBooks(null); // Tải dữ liệu khi mở ứng dụng
    }

    private void loadBooks(ActionEvent e) {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trong bảng
        List<Book> books = XMLHandler.readXML(); // Đọc từ file XML
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getId(), book.getTitle(), book.getAuthor(), book.getYear()});
        }
    }

    private void addBook(ActionEvent e) {
        XMLHandler.addBook(txtId.getText(), txtTitle.getText(), txtAuthor.getText(), txtYear.getText());
        loadBooks(null); // Cập nhật bảng sau khi thêm
    }

    private void deleteBook(ActionEvent e) {
        XMLHandler.deleteBook(txtId.getText());
        loadBooks(null); // Cập nhật bảng sau khi xóa
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new XMLGUI().setVisible(true));
    }
}
