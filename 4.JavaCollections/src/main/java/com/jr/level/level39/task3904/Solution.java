package com.jr.level.level39.task3904;

/*
Лестница
*/

public class Solution {
//    private static int n = 70;
    private static int n = 6;
    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        long n0,n1,n2;
        n0 = n1 = n2 = 0;
        long res = 1;
        for(int i = 0; i < n; i++){
            n0 = n1;
            n1 = n2;
            n2 = res;
            res = n0 + n1 + n2;
        }

        return res;
    }
}

