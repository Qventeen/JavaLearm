package com.jr.level.level15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;
    static {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            A = Integer.parseInt(rd.readLine());
            B = Integer.parseInt(rd.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b)  {
        return a < b ? a : b;
    }
}
