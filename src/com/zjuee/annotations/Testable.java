package com.zjuee.annotations;

import com.zjuee.util.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    public void testExecute() {
        execute();
    }
}
