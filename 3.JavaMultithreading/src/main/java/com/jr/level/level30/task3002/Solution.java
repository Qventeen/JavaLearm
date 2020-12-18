package com.jr.level.level30.task3002;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62

    }

    public static String convertToDecimalSystem(String s) {
        int radix = 10;
        char test0 = s.charAt(0);
        char test1 = s.charAt(1);
        if('0' == test0){
            if('x' == test1){
                radix = 16;
                s = s.substring(2);
            }else if('b' == test1){
                radix = 2;
                s = s.substring(2);
            }else{
                radix = 8;
                s = s.substring(1);
            }
        }
        return Integer.toString(Integer.parseInt(s, radix));
    }
}
