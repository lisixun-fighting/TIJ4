package com.zjuee.io.xml;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class People extends ArrayList<Person> {
    public People(String filename) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(filename);
        Element root = doc.getDocumentElement();
        System.out.println(root.getTagName());
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if(child instanceof Element) {
                Node firstNode = ((Element) child).getElementsByTagName("first").item(0);
                String first = firstNode.getTextContent();
                Node lastNode = ((Element) child).getElementsByTagName("last").item(0);
                String last = lastNode.getTextContent();
                Node addressNode = ((Element) child).getElementsByTagName("address").item(0);
                String address = addressNode.getTextContent();
                add(new Person(first, last, address));
            }
        }
    }

    public static void main(String[] args) throws Exception{
        People p = new People("F:/JAVA/IdeaProjects/TIJ4/src/com/zjuee/io/xml/People.xml");
        System.out.println(p);
    }
}
