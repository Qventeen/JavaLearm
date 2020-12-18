package com.jr.level.level39.task3909;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {
        isOneEditAway("Hello world", "Hello world");
    }


    public static boolean isOneEditAway(String first, String second) {
        if(first == null || second == null) return false;
        if(Math.abs(first.length() - second.length()) > 1) return false;
        if(first.isEmpty() || second.isEmpty()) return true;

        int count = 0;
        String fr;
        String sc;
        if(first.length() <= second.length()){
            fr = first; sc = second;
        } else{
            fr = second; sc = first;
        }

        for(int f = 0, s = 0; f < fr.length(); f++, s++){
            if(fr.charAt(f) != sc.charAt(s)){
                count++;
                if(count > 1) return false;
                if(fr.length() < sc.length()) f--;
            }
        }
        return true;
    }
}
