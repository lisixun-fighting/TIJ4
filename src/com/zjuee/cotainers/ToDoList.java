package com.zjuee.cotainers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 存放ToDoItem的List容器
 * 可以对Item进行排序
 */
class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
//    public ToDoList(Comparator<? super ToDoItem> comparator) {
//        super(comparator);
//    }
    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(String td, char pri, int sec) {
            primary = pri;
            secondary = sec;
            item = td;
        }
        public int compareTo(ToDoItem arg) {
            if(primary > arg.primary) {
                return +1;
            }
            if(primary == arg.primary) {
                if(secondary > arg.secondary) {
                    return +1;
                }
                else if(secondary == arg.secondary)
                    return 0;
            }
            return -1;
        }
        @Override
        public String toString() {
            return "ToDoItem{" +
                    "primary=" + primary +
                    ", secondary=" + secondary +
                    ", item='" + item + '\'' +
                    '}';
        }
    }
    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(td, pri, sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while(!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }
}

/**
 * 练习11
 */
class SortedIntegerList extends PriorityQueue<SortedIntegerList.Item> {
    static class Item implements Comparable<Item> {
        int val;
        public Item(int val) {
            this.val = val;
        }
        @Override
        public int compareTo(Item o) {
            return Integer.compare(val, o.val);
        }
        @Override
        public String toString() {
            return "Item{" +
                    "val=" + val +
                    '}';
        }
    }
    public void add(int val) {
        super.add(new Item(val));
    }

    public static void main(String[] args) {
        Random rd = new Random(47);
        SortedIntegerList list = new SortedIntegerList();
        for (int i = 0; i < 100; i++) {
            list.add(rd.nextInt(100));
        }
        while(!list.isEmpty()) {
            System.out.println(list.poll());
        }
    }
}
