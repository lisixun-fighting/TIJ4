package com.zjuee.control;

import static net.mindview.util.Print.print;

public class Fibonacci {
    public static void main(String[] args) {

        int[] dp = new int[]{0, 1};
        if(args.length == 0)
            print("res = " + dp[1]);
        else {
            int num = 0;
            try {
                num = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            for (int i = 1; i < num; i++) {
                int tmp = dp[1];
                dp[1] = dp[0] + dp[1];
                dp[0] = tmp;
            }
            print("res = " + dp[1]);
        }
    }
}
