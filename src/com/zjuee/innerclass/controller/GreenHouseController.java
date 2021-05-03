package com.zjuee.innerclass.controller;

import com.zjuee.innerclass.GreenHouseControls;

public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(400),
                gc.new LightOff(600),
                gc.new WaterOn(800),
                gc.new FanOff(1000),
                gc.new WaterOff(1200),
                gc.new ThermostatDay(1400)
        };
        // 构造器先执行，因此先将列表中的事件添加到gc，再将自身Restart添加到gc去。
        gc.addEvent(gc.new Restart(2000,eventList));
        // 添加终结事件，Restart事件执行完毕后紧跟着执行。
        gc.addEvent(new GreenHouseControls.Terminate(50000));
        gc.run();
    }
}
