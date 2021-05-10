package com.zjuee.io.xml;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

import java.util.ArrayList;

public class People extends ArrayList<Person> {
    public People(String filename) throws Exception {
        Document doc = new Builder().build(filename);
        Elements elements = doc.getRootElement().getChildElements();

        for (int i = 0; i < elements.size(); i++)
            add(new Person(elements.get(i)));

    }

    public static void main(String[] args) throws Exception{
        People p = new People("F:/JAVA/IdeaProjects/TIJ4/src/com/zjuee/io/xml/People.xml");
        System.out.println(p);
    }
}
