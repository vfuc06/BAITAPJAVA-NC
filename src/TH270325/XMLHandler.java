package TH270325;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {
    private static final String FILE_PATH ="src/TH270325/data.xml";

    public static List<Book> readXML() {
        List<Book> books = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || file.length() == 0) {
                return books; // Trả về danh sách rỗng nếu file chưa tồn tại hoặc rỗng
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            if (!doc.getDocumentElement().getNodeName().equals("data")) {
                System.out.println("Sai định dạng XML! Cần root là <data>");
                return books;
            }

            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element bookElem = (Element) nodeList.item(i);
                String id = bookElem.getAttribute("id");
                String title = bookElem.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElem.getElementsByTagName("author").item(0).getTextContent();
                String year = bookElem.getElementsByTagName("year").item(0).getTextContent();
                books.add(new Book(id, title, author, year));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    // Thêm sách mới vào XML
    public static void addBook(String id, String title, String author, String year) {
        try {
            File file = new File(FILE_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;

            // Nếu file không tồn tại hoặc rỗng, tạo mới với root <data>
            if (!file.exists() || file.length() == 0) {
                doc = builder.newDocument();
                Element root = doc.createElement("data");
                doc.appendChild(root);
            } else {
                doc = builder.parse(file);
                doc.getDocumentElement().normalize();
            }

            Element root = doc.getDocumentElement();

            Element book = doc.createElement("book");
            book.setAttribute("id", id);

            Element titleElem = doc.createElement("title");
            titleElem.appendChild(doc.createTextNode(title));
            book.appendChild(titleElem);

            Element authorElem = doc.createElement("author");
            authorElem.appendChild(doc.createTextNode(author));
            book.appendChild(authorElem);

            Element yearElem = doc.createElement("year");
            yearElem.appendChild(doc.createTextNode(year));
            book.appendChild(yearElem);

            root.appendChild(book);

            saveXML(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(String id) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element book = (Element) nodeList.item(i);
                if (book.getAttribute("id").equals(id)) {
                    book.getParentNode().removeChild(book);
                    break;
                }
            }

            saveXML(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveXML(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_PATH));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
