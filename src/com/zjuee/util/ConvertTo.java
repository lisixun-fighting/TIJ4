package com.zjuee.util;

public class ConvertTo {
    public static boolean[] primitive(Boolean[] in) {
        boolean[] res = new boolean[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
    public static char[] primitive(Character[] in) {
        char[] res = new char[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
    public static byte[] primitive(Byte[] in) {
        byte[] res = new byte[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
    public static short[] primitive(Short[] in) {
        short[] res = new short[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
    public static int[] primitive(Integer[] in) {
        int[] res = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
    public static double[] primitive(Double[] in) {
        double[] res = new double[in.length];
        for (int i = 0; i < in.length; i++) {
            res[i] = in[i];
        }
        return res;
    }
}
