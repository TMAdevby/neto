package org.example.CSV_XML_JSON.XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public Main() throws ParserConfigurationException {
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        //чтение документа  читает корневой элемент
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document doc = builder.parse(new File("company.xml"));
//
//        Node root = doc.getDocumentElement();
//        System.out.println("Корневой элемент: " + root.getNodeName());
//        read(root);



        // создание и запись
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        Element company = document.createElement("company");
        document.appendChild(company);
        Element equipment = document.createElement("equipment");
        document.appendChild(equipment);
        Element staff = document.createElement("staff");
        document.appendChild(staff);
        Element employee = document.createElement("employee");
        employee.setAttribute("id","3");
        employee.setAttribute("firstname","Nikita");
        employee.setAttribute("lastname","Shumski");
    }

    private static void read(Node node){
        NodeList nodeList = node.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()){
                System.out.println("Текущий узел: " + node_.getNodeName());
                Element element = (Element) node_;
                NamedNodeMap map = element.getAttributes();
                for(int a = 0; a < map.getLength(); a++){
                    String attrName = map.item(a).getNodeName();
                    String attrValue = map.item(a).getNodeValue();
                    System.out.println("Атрибут: " + attrName + ": значение: " + attrValue);
                }
                read(node_);
            }
        }
    }



}
