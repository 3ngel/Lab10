package Lessions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import java.io.File;
import java.util.Scanner;

public class Less1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Library");
            doc.appendChild(rootElement);

            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Война и мир"));
            book1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Лев Толстой"));
            book1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1869"));
            book1.appendChild(year1);

            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Михаил Булгаков"));
            book2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1967"));
            book2.appendChild(year2);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result =
                    new javax.xml.transform.stream.StreamResult(new File("src/Lessions/Files/Less1.xml"));
            transformer.transform(source, result);

            System.out.println("XML-файл готов");

            Scanner scan =new Scanner(System.in);
            System.out.println("Введите название книги ");
            String title = scan.nextLine();
            System.out.println("Введите название книги ");
            String author = scan.nextLine();
            System.out.println("Введите название книги ");
            String year = scan.nextLine();

            Element book3 = doc.createElement("book");
            rootElement.appendChild(book3);

            Element title3 = doc.createElement("title");
            title3.appendChild(doc.createTextNode(title));
            book3.appendChild(title3);

            Element author3 = doc.createElement("author");
            author3.appendChild(doc.createTextNode(author));
            book3.appendChild(author3);

            Element year3 = doc.createElement("year");
            year3.appendChild(doc.createTextNode(year));
            book3.appendChild(year3);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            source = new javax.xml.transform.dom.DOMSource(doc);
            result = new javax.xml.transform.stream.StreamResult(new File("src/Lessions/Files/Less1.xml"));
            transformer.transform(source, result);

            System.out.println("XML-файл готов");

        } catch (Exception pse) {
            pse.printStackTrace();
        }
    }
}
