package Bcrypt;

import org.mindrot.jbcrypt.BCrypt;
import javax.swing.*;
import org.w3c.dom.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class UserManager {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String hashedPassword, String userPassword) {
        return BCrypt.checkpw(userPassword, hashedPassword);
    }

    public static void saveUserToXML(String name, String className, String studentId, String username, String hashedPassword) {
        try {
            File xmlFile = new File("users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            if (xmlFile.exists()) {
                doc = dBuilder.parse(xmlFile);
            } else {
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("users");
                doc.appendChild(rootElement);
            }

            Element root = doc.getDocumentElement();
            Element userElement = doc.createElement("user");

            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));
            userElement.appendChild(nameElement);

            Element classElement = doc.createElement("class");
            classElement.appendChild(doc.createTextNode(className));
            userElement.appendChild(classElement);

            Element studentIdElement = doc.createElement("studentId");
            studentIdElement.appendChild(doc.createTextNode(studentId));
            userElement.appendChild(studentIdElement);

            Element usernameElement = doc.createElement("username");
            usernameElement.appendChild(doc.createTextNode(username));
            userElement.appendChild(usernameElement);

            Element passwordElement = doc.createElement("password");
            passwordElement.appendChild(doc.createTextNode(hashedPassword));
            userElement.appendChild(passwordElement);

            root.appendChild(userElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(xmlFile));

            JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }

    public static void displayUsers(DefaultTableModel tableModel) {
        try {
            File xmlFile = new File("users.xml");
            if (!xmlFile.exists()) {
                JOptionPane.showMessageDialog(null, "Không có người dùng nào!");
                return;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            // Xóa dữ liệu cũ trong bảng
            tableModel.setRowCount(0);

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    String name = getTextContentSafe(eElement, "name");
                    String className = getTextContentSafe(eElement, "class");
                    String studentId = getTextContentSafe(eElement, "studentId");
                    String username = getTextContentSafe(eElement, "username");

                    // Thêm dòng mới vào bảng
                    tableModel.addRow(new Object[]{name, className, studentId, username});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu: " + e.getMessage());
        }
    }


    public static boolean loginUser(String username, String password) {
        try {
            File xmlFile = new File("users.xml");
            if (!xmlFile.exists()) {
                JOptionPane.showMessageDialog(null, "Chưa có người dùng nào!");
                return false;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String storedUsername = getTextContentSafe(eElement, "username");
                    String storedHashedPassword = getTextContentSafe(eElement, "password");
                    if (username.equals(storedUsername) && checkPassword(storedHashedPassword, password)) {
                        String name = getTextContentSafe(eElement, "name");
                        String className = getTextContentSafe(eElement, "class");
                        String studentId = getTextContentSafe(eElement, "studentId");
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công!\n" +
                                "Tên: " + name + "\n" +
                                "Lớp: " + className + "\n" +
                                "Mã SV: " + studentId);
                        return true;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đăng nhập: " + e.getMessage());
        }
        return false;
    }

    private static String getTextContentSafe(Element element, String tagName) {
        NodeList nodes = element.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            return nodes.item(0).getTextContent();
        }
        return null;  // Trả về null nếu không tìm thấy dữ liệu
    }

    public static void clearXMLData() {
        File xmlFile = new File("users.xml");
        if (xmlFile.exists()) {
            if (xmlFile.delete()) {
                JOptionPane.showMessageDialog(null, "Đã xóa toàn bộ dữ liệu!");
            } else {
                JOptionPane.showMessageDialog(null, "Không thể xóa dữ liệu.");
            }
        }
    }
}
