package com.jr.level.level39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        isPalindromePermutation("abcdefgabcdefgabdefgabcdefg");
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.isEmpty()) return false;
        if(s.length() == 1) return true;

        char[] chars = s.toLowerCase().toCharArray();
        Arrays.sort(chars);
        int evenCounter = 0;
        int oddCounter = 0;
        char old = chars[0];
        for(char cur: chars){
            if(old == cur)
                evenCounter++;
            else if(evenCounter % 2 == 0) evenCounter = 1;
            else if(oddCounter > 0) return false;
            else {
                oddCounter++;
                evenCounter = 1;
            }
            old = cur;
        }
        return evenCounter % 2 == 0 || oddCounter == 0;
    }
}
