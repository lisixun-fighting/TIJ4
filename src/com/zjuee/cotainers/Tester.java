package com.zjuee.cotainers;

import java.util.*;

public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    // Override this to modify pre-test initialization;
    protected C initialize(int size) { return container; }
    private String headline = "";
    protected static String stringField() {
        return "%" + fieldWidth + "s";
    }
    protected static String numberField() {
        return "%" + fieldWidth + "d";
    }
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    protected C container;
    private TestParam[] paramList = defaultParams;
    private List<Test<C>> tests;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if(container != null)
            this.headline = container.getClass().getSimpleName();
    }
    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadline(String newHeadline) {
        this.headline = newHeadline;
    }

    // Generic methods for convenience;
    public static <C> void run(C container, List<Test<C>> tests) {
        new Tester<C>(container, tests).timedTest();
    }
    public static <C> void run(C container, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(container, tests, paramList).timedTest();
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++)
            head.append("-");
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++)
            head.append("-");
        System.out.println(head);
        // Print column headers
        System.out.format(sizeField, "size");
        for (Test<C> test : tests)
            System.out.format(stringField(), test.name);
        System.out.println();
    }

    // Run the tests for this container
    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                // Call the override method:
                int reps = test.test(kontainer, param);
                // counting test time
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
