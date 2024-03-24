package Lessions;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Less1Read {
    public static void main(String[] args){
        try{
            File inputFile = new File("src/Lessions/Files/Less1.xml");
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент "+doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                System.out.println("\n Текущий элемент "+node.getNodeName());
                if (node.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Название книги "+element.getElementsByTagName("title").item(0)
                            .getTextContent());
                    System.out.println("Автор "+element.getElementsByTagName("author").item(0)
                            .getTextContent());
                    System.out.println("Год выхода "+element.getElementsByTagName("year").item(0)
                            .getTextContent());
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
