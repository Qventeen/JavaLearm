package com.jr.level.level39.task3903;

import java.io.IOException;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Please enter a number: ");
//
//        long number = Long.parseLong(reader.readLine());
//        System.out.println("Please enter the first index: ");
//        int i = Integer.parseInt(reader.readLine());
//        System.out.println("Please enter the second index: ");
//        int j = Integer.parseInt(reader.readLine());
        int i = (int) (Math.random() * 64);
        int j = (int) (Math.random() * 64);
        long number = (long) (Math.random() * Long.MAX_VALUE);


        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        if(((number >>> i) & 1) != ((number >>> j) & 1)){
            long mask = (1L << i) | (1L << j);
            number ^= mask;
        }
        return number;
    }
}
