package com.jr.level.level30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        final int RADIX = 10;
        Set<Integer> result = new HashSet<>();
        try {
            int tmp = Integer.parseInt(number, RADIX);
            for(int r = Character.MIN_RADIX; r <= Character.MAX_RADIX; r++){
                if(isPolindrom(Integer.toString(tmp,r).toCharArray())){
                    result.add(r);
                }
            }
        } catch (NumberFormatException ignored){}

        return result;

    }

    private static boolean isPolindrom(char[] testNumber){
        for(int s = 0, e = testNumber.length-1; s < e; s++, e--){
           if(testNumber[s] != testNumber[e]){
               return false;
           }
        }
       return true;
    }

}
