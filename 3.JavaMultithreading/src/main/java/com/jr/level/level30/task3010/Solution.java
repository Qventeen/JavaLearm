package com.jr.level.level30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/


public class Solution {
    public static void main(String[] args) {
        //проверить строку регулярным выражением на наличие неподходящих символов
        //корретными символами числа с основанием от 2 до 36 есть \\p{Alnum}
//        String[] args1 = new String[1];
//        args1[0] = "uieuied";
        try {
            if (args[0].length() <= 255 && args[0].matches("[0-9a-zA-Z]+")) {
                //Получить байт массив символов
                byte[] mass = args[0].toLowerCase().getBytes();
                int max = mass[0];
                for (byte c : mass) {
                    max = Math.max(max, c);
                }
                for (int radix = Character.MIN_RADIX; radix <= Character.MAX_RADIX; radix++) {
                    if (Character.digit((char) max, radix) >= 0) {
                        System.out.println(radix);
                        return;
                    }
                }
            }
            System.out.println("incorrect");
        } catch (Throwable e) {
        }

    }
}
