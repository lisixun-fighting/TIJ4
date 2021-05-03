package com.zjuee.cotainers;

import java.lang.ref.*;
import java.util.*;

class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) { ident = id; }
    public String toString() { return ident; }
    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}

public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();
    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null)
            System.out.println("In queue: " + inq.get());
    }
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        if(args.length > 0)
            size = Integer.parseInt(args[0]);
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created: " + sa.getLast());
            checkQueue();
        }
//        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
//        VeryBig veryBig = s.get();
        new VeryBig("Soft");
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak"));
        System.gc();
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<>(new VeryBig("Phantom " + i), rq));
            System.out.println("Just created: " + pa.getLast());
            checkQueue();
        }
        System.gc();
    }
}
