package com.jr.level.level22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int start;
        int end;
        String result;
        try {
            start = string.indexOf('\t')+1;
            end = string.indexOf('\t',start);
            result = string.substring(start, end);
        } catch (Exception e){
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJR - лучший сервис \tобучения Java\t."));
    }
}
