package Encryptable;

import javax.swing.*;
import java.awt.*;

public class EncryptUI extends JFrame {
    private JTextField inputField;
    private JButton aesButton, rsaButton, decryptButton;
    private JTextArea resultArea;
    private Encryptable lastEncryptor;

    public EncryptUI() {
        setTitle("Encryptor UI");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLookAndFeel();

        inputField = new JTextField(30);
        aesButton = new JButton("Encrypt with AES");
        rsaButton = new JButton("Encrypt with RSA");
        decryptButton = new JButton("Decrypt Last");
        resultArea = new JTextArea(6, 45);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter text:"));
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aesButton);
        buttonPanel.add(rsaButton);
        buttonPanel.add(decryptButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        aesButton.addActionListener(e -> {
            try {
                AESEncryptor aes = new AESEncryptor();
                lastEncryptor = aes;
                EncryptDecryptThread thread = new EncryptDecryptThread(aes, inputField.getText(), resultArea, true);
                thread.start();
            } catch (Exception ex) {
                showError(ex.getMessage());
            }
        });

        rsaButton.addActionListener(e -> {
            try {
                RSAEncryptor rsa = new RSAEncryptor();
                lastEncryptor = rsa;
                EncryptDecryptThread thread = new EncryptDecryptThread(rsa, inputField.getText(), resultArea, true);
                thread.start();
            } catch (Exception ex) {
                showError(ex.getMessage());
            }
        });

        decryptButton.addActionListener(e -> {
            if (lastEncryptor == null) {
                showError("No previous encryption to decrypt.");
                return;
            }
            String encryptedText = resultArea.getText().trim();
            if (encryptedText.isEmpty()) {
                showError("Nothing to decrypt.");
                return;
            }

            EncryptDecryptThread thread = new EncryptDecryptThread(lastEncryptor, encryptedText, resultArea, false);
            thread.start();
        });

        setVisible(true);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EncryptUI::new);
    }
}
