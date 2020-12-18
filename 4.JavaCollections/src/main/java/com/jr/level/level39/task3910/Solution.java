package com.jr.level.level39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {
        isPowerOfThree(9);
    }

    public static boolean isPowerOfThree(int n) {
        int k = 1;
        while(k < n) k *= 3;
        if(k == n)
            return true;
        return false;
    }
}
