package com.zjuee.io.xml;

import nu.xom.*;

import java.io.*;
import java.util.*;

public class Person {
    private String first, last, address;
    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        Element addressName = new Element("address");
        addressName.appendChild(address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(addressName);
        return person;
    }
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }
    public String toString() {
        return first + " " + last + " " + address;
    }

    public static void format(OutputStream out, Document doc) throws Exception {
        Serializer serializer = new Serializer(out, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }
    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "Xi'an"),
                new Person("Gonzo", "The Great", "Shanghai"),
                new Person("Philip J.", "Fry", "Hangzhou"));
        System.out.println(people);
        Element root = new Element("people");
        for(Person p : people)
            root.appendChild(p.getXML());

        Document doc = new Document(root);

        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("src/com/zjuee/io/xml/People.xml")), doc);
    }
}
