package Encryptable;

import javax.swing.*;

public class EncryptDecryptThread extends Thread {
    private final Encryptable encryptor;
    private final String input;
    private final JTextArea resultArea;
    private final boolean isEncrypt;

    public EncryptDecryptThread(Encryptable encryptor, String input, JTextArea resultArea, boolean isEncrypt) {
        this.encryptor = encryptor;
        this.input = input;
        this.resultArea = resultArea;
        this.isEncrypt = isEncrypt;
    }

    @Override
    public void run() {
        try {
            String result = isEncrypt ? encryptor.encrypt(input) : encryptor.decrypt(input);
            SwingUtilities.invokeLater(() -> resultArea.setText(result));
        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> resultArea.setText("Error: " + e.getMessage()));
        }
    }
}
