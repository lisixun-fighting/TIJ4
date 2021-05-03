package com.zjuee.cotainers;

import java.util.*;

import com.zjuee.arrays.CountingGenerator;
import com.zjuee.cotainers.TestParam;
import com.zjuee.cotainers.Tester;
import com.zjuee.cotainers.Test;
import com.zjuee.util.Generated;
import com.zjuee.util.*;

public class ListPerformance {
    static Random random = new Random();
    static int reps = 10000;
    static List<Test<List<String>>> tests = new ArrayList<>();

    static  {
        tests.add(new Test<>("add") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add("a");
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<>("get") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(random.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<>("set") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(random.nextInt(listSize), "a");
                return loops;
            }
        });
        tests.add(new Test<>("iteradd") {
            public int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator();
                for (int i = 0; i < LOOPS; i++)
                    it.add("a");
                return LOOPS;
            }
        });
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }
        // Fill to the appropriate size before each test;
        protected List<String> initialize(int size) {
            container.clear();
            List<String> cForInit = new ArrayList<>();
            Generator<String> gen = new CountingGenerator.String();
            for (int i = 0; i < size; i++)
                cForInit.add(gen.next());
            container.addAll(cForInit);
            return container;
        }
        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        // Can only do these two tests on an array
        Tester<List<String>> arrayTest = new Tester<>(null, tests.subList(1, 2)) {
            protected List<String> initialize(int size) {
                String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
//         set testParams : size and loops
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);

        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new Vector<>(), tests);
    }
}
