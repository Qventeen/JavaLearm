package com.jr.level.level39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(lengthOfLongestUniqueSubstring("ttttwt"));
//        System.out.println(lengthOfLongestUniqueSubstring("a123bcbcqwe"));
        System.out.println(lengthOfLongestUniqueSubstring("hello my friend"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        int startString = 0;
        char ch;
        for(int index = 0; index< s.length(); index++){
            ch = s.charAt(index);
            if(set.contains(ch)){
                startString = s.indexOf(ch, startString);
                index = startString++;
                set.clear();
            } else {
                set.add(ch);
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
