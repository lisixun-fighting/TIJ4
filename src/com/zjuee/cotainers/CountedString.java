package com.zjuee.cotainers;
// Creating a good hashCode();
import java.util.*;

public class CountedString {
    private static List<String> created = new ArrayList<String>();
    private String s;
    private char c;
    private int id = 0;
    public CountedString(String str, char ch) {
        s = str;
        c = ch;
        created.add(s);
        for (String s2 : created)
            if(s2.equals(s))
                id++;
    }
    public String toString() {
        return "String:" + s + " char:" + c + " id:" + id + " hashCode():" + hashCode();
    }
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + c;
//        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString
//                && s.equals(((CountedString)o).s)
//                && id == ((CountedString)o).id;
            && o.hashCode() == hashCode();
    }

    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<CountedString,Integer>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'a');
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println(cstring);
            System.out.println(map.get(cstring));
        }
    }
}
