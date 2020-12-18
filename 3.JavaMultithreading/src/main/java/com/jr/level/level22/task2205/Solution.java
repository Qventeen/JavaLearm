package com.jr.level.level22.task2205;

/* 
МНЕ нравится курс JR
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JR", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JR"
    }
    public static String getFormattedString() {
        return "%3$S %4$s %2$s %1$s";
    }
}
