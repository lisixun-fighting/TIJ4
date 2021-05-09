package com.zjuee.annotations;

import com.zjuee.atunit.Test;
import com.zjuee.util.OSExecute;

public class AtUnitExample1 {
    public String methodOne() {
        return "This is methodOne";
    }
    public int methodTwo() {
        System.out.println("This method 2");
        return 2;
    }
    @Test
    public boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }
    @Test
    boolean m2() {
        return methodTwo() == 2;
    }
    @Test
    private boolean m3() { return true; }
    @Test
    boolean failureTest() {
        return false;
    }
    @Test
    boolean anotherDisappointment() { return false; }

    public static void main(String[] args) {
        OSExecute.command(
                "java com.zjuee.atunit.AtUnit  AtUnitExample1"
        );
    }
}
