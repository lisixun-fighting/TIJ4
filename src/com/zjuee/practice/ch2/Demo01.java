package com.zjuee.practice.ch2;

import static net.mindview.util.Print.print;

class Tank {
    float val;
}

public class Demo01 {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        t1.val = 1.0f;
        Tank t2 = new Tank();
        t2.val = 2.0f;
        print("t1="+t1.val+", t2="+t2.val);
        t1 = t2;
        print("t1="+t1.val+", t2="+t2.val);
        t2.val = 3.0f;
        print("t1="+t1.val+", t2="+t2.val);
    }
}
