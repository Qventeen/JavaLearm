package com.jr.level.level22.task2210;


import java.util.LinkedList;
import java.util.StringTokenizer;
/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
//        String [] strs = getTokens("level22.lesson13.task01", ".");
//        for(String s: strs){
//            System.out.println(s);
//        }

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        LinkedList<String> sb = new LinkedList<>();
        while(st.hasMoreTokens()){
            sb.add(st.nextToken());
        }
        String [] result = new String[sb.size()];

        return sb.toArray(result);
    }
}
