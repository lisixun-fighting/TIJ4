package com.zjuee.generics;

import java.math.*;
import java.util.concurrent.atomic.*;
import java.util.*;

interface Combiner<T> {
    T combine(T x, T y);
}
interface UnaryFunction<R,T> {
    R function(T x);
}
interface Collector<T> extends UnaryFunction<T,T> {
    T result();
}
interface UnaryPredicate<T> {
    boolean test(T x);
}

public class Functional {
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if(it.hasNext()) {
            T result = it.next();
            while (it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        return null;
    }
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq)
            func.function(t);
        return func;
    }
    public static <R,T> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func) {
        List<R> res = new ArrayList<>();
        for (T t : seq)
            res.add(func.function(t));
        return res;
    }
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> res = new ArrayList<>();
        for (T t : seq) {
            if(pred.test(t))
                res.add(t);
        }
        return res;
    }
    static class IntegerAdder implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }
    static class IntegerSubtracter implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }
    static class BigIntegerAdder implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }
    static class AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }
    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }
    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private final T bound;
        public GreaterThan(T bound) {
            this.bound = bound;
        }
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }
    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;
        public Integer function(Integer x) {
            val *= x;
            return val;
        }
        public Integer result() { return val; }
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);

        result = reduce(li, new IntegerSubtracter());
        System.out.println(result);

        System.out.println(filter(li, new GreaterThan<>(4)));

        System.out.println(forEach(li, new MultiplyingIntegerCollector()).result());

        System.out.println(forEach(filter(li,new GreaterThan<>(4)), new MultiplyingIntegerCollector()).result());

    }
}
