package com.jr.level.level22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        
        return telNumber != null? telNumber.matches(
            "^(((\\+\\d{2}))?(\\(\\d{3}\\)|(\\d{3})))(\\d{3})((\\d{4})|(-\\d{4})|(-\\d{2}-\\d{2}))$"
            ) 
            : false;
    }

    public static void main(String[] args) {
        
    }
}
