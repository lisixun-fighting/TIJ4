package com.zjuee.innerclass;

import com.zjuee.innerclass.controller.Controller;
import com.zjuee.innerclass.controller.Event;

public class GreenHouseControls extends Controller {
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime){
            super(delayTime);
        }
        public void action() {
            light = true;
        }
        public String toString(){
            return "Light is on";
        }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime){
            super(delayTime);
        }
        public void action() {
            light = false;
        }
        public String toString(){
            return "Light is off";
        }
    }

    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime){
            super(delayTime);
        }
        public void action() {
            water = true;
        }
        public String toString() {
            return "GreenHouse Water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime){
            super(delayTime);
        }
        public void action() {
            water = false;
        }
        public String toString() {
            return "GreenHouse Water is off";
        }
    }

    private boolean fan = false;
    public class FanOn extends Event {
        public FanOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            fan = true;
        }
        public String toString() {
            return "Fan is on";
        }
    }

    public class FanOff extends Event {
        public FanOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            fan = false;
        }
        public String toString() {
            return "Fan is off";
        }
    }

    private String thermostat = "Day";
    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat = "Night";
        }
        public String toString(){
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat = "Day";
        }
        public String toString(){
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime){
            super(delayTime);
        }
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList) {
                addEvent(e); // 给外部类的eventList添加事件
            }
        }
        // 在执行Restart内部类的action方法时，会重新将eventList中的事件加载到GreenHouseControls中去，这样就可以一直循环下去。
        public void action(){
            for(Event e : eventList){
                e.start();
                addEvent(e);
            }
            start(); // 这相当于设定下一次restart时间
            addEvent(this);
        }
        public String toString() {
            return "Restarting System";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        public void action() {
            System.exit(0);
        }
        public String toString() {
            return "Terminating";
        }
    }
}
