package com.jr.level.level22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JR - лучший сервис "));
    }
    // обучения Java.
    public static String getPartOfString(String string) {
        try {
            String[] strs = string.split(" ");
            if (strs.length < 5)
                throw new TooShortStringException();
            return String.format("%s %s %s %s", strs[1], strs[2], strs[3], strs[4]);

        } catch (RuntimeException e){
            throw new TooShortStringException();
        }
    }
    public static class TooShortStringException extends RuntimeException {
    }
}
