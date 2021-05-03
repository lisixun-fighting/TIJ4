package com.zjuee.innerclass.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// The reusable frame for control system
public class Controller {
    private List<Event> eventList = new LinkedList<>();
    public void addEvent(Event c){
        eventList.add(c);
    }
    public void run(){
        while(eventList.size() > 0){
            Iterator<Event> it = new LinkedList<>(eventList).iterator();
            while (it.hasNext()) {
                Event c = it.next();
                if(c.ready()) {
                    System.out.println(c);
                    c.action();
                    it.remove();
                }
            }
        }
    }
}
