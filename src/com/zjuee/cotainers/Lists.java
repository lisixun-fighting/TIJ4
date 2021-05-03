package com.zjuee.cotainers;

import com.zjuee.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        a.addAll(3, Countries.names(4));
        b=a.contains("1"); // false
        b=a.containsAll(Countries.names(4)); // true
        s = a.get(1);  // x
        i = a.indexOf("1"); // -1
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);  // start at loc 3
        System.out.println(a);
        a.retainAll(Countries.names(4));
        System.out.println(a);
        a.removeAll(Countries.names(4));
        System.out.println(a);
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        it.next();
        it.remove();
        it.next();
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = Countries.names(5);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);

        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        x = a.listIterator(a.size());
        while(x.hasPrevious())
            System.out.print(x.previous() + " ");
        System.out.println();

    }

    public static void main(String[] args) {
//        basicTest(new LinkedList<String>(Countries.names(4)));
//        testVisual(new LinkedList<String>(Countries.names(5)));
        iterManipulation(new LinkedList<>(Countries.names()));
    }
}
