package com.zjuee.cotainers;

import java.util.*;

public class MapPerformance {
    static List<Test<Map<Integer,Integer>>> tests = new LinkedList<>();
    static {
        tests.add(new Test<>("put") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j,j);
                }
                return loops * size;
            }
        });
        tests.add(new Test<>("get") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++)
                        map.get(j);
                }
                return loops * span;
            }
        });
        tests.add(new Test<>("iterate") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
//        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(100), tests);
        Tester.run(new HashMap<>(1000), tests);
        Tester.run(new HashMap<>(10000), tests);
//        Tester.run(new LinkedHashMap<>(), tests);
//        Tester.run(new IdentityHashMap<>(), tests);
//        Tester.run(new WeakHashMap<>(), tests);
//        Tester.run(new Hashtable<>(), tests);
//        Tester.run(new SimpleHashMap<>(), tests);
//        Tester.run(new SlowMap<>() , tests);
    }
}
