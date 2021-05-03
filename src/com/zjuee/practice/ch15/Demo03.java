package com.zjuee.practice.ch15;

interface TCP {
    void ack();
    void fin();
}

class Connect implements TCP {
    @Override
    public void ack() {
        System.out.println("Connect.ack()");
    }
    @Override
    public void fin() {
        System.out.println("Connect.fin()");
    }
}

class Close {

    public <T extends TCP> void ack(T t) {
        t.ack();
        t.fin();
    }

}

public class Demo03 {
    public static void main(String[] args) {
        Close c = new Close();
        c.ack(new Connect());
    }

}
