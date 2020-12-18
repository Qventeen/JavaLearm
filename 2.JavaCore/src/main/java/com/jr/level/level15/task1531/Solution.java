package com.jr.level.level15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        int tmp = n<0? 0: 1;
        BigDecimal rez = new BigDecimal(tmp);

        for (int i = 1; i <= n; i++) {
            rez = rez.multiply(new BigDecimal(i));
        }
        String tmp2  = rez.toString();
        return tmp2;
    }
}
