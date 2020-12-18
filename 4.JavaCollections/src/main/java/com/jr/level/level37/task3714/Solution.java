package com.jr.level.level37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;
        int lastCh = 0;
        int nextCh = 0;

        for(int ch: s.toUpperCase().toCharArray()){
            lastCh = nextCh;
            switch(ch){
                case 'I':nextCh = 1; break;
                case 'V':nextCh = 5; break;
                case 'X':nextCh = 10; break;
                case 'L':nextCh = 50; break;
                case 'C':nextCh = 100; break;
                case 'D':nextCh = 500; break;
                case 'M':nextCh = 1000; break;
            }
            result = (lastCh < nextCh)?
                    result - lastCh :
                    result + lastCh;
        }
        result += nextCh;

        return result;
    }
}
