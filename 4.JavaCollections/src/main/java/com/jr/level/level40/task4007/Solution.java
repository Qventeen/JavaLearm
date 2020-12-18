package com.jr.level.level40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;


/* 
Работа с датами
*/

public class Solution {
    private static final DateFormat dateTimeFormat = new SimpleDateFormat("d.M.y H:m:s");
    private static final DateFormat timeFormat = new SimpleDateFormat("H:m:s");
    private static final DateFormat dateFormat = new SimpleDateFormat("d.M.y");

    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
        System.out.println();
//        printDate("13.1.2019");
//        printDate("1.1.1");
    }

    public static void printDate(String date) {
        Objects.nonNull(date);
        Calendar calendar = Calendar.getInstance();

        try {
            if(date.length() > 10){
                calendar.setTime(dateTimeFormat.parse(date));
                printDateTime(calendar);
            } else if(date.contains(".")){
                calendar.setTime(dateFormat.parse(date));
                printDate(calendar);
            } else if(date.contains(":")){
                calendar.setTime(timeFormat.parse(date));
                printTime(calendar);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void printDateTime(Calendar calendar){
        printDate(calendar);
        printTime(calendar);
    }

    private static void printDate(Calendar calendar){
        printf("День: %d%n", calendar.get(Calendar.DATE));
        printf("День недели: %d%n", calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1);
        printf("День месяца: %d%n", calendar.get(Calendar.DAY_OF_MONTH));
        printf("День года: %d%n", calendar.get(Calendar.DAY_OF_YEAR));
        printf("Неделя месяца: %d%n", calendar.get(Calendar.WEEK_OF_MONTH));
        printf("Неделя года: %d%n", calendar.get(Calendar.WEEK_OF_YEAR));
        printf("Месяц: %d%n", calendar.get(Calendar.MONTH) + 1);
        printf("Год: %d%n", calendar.get(Calendar.YEAR));
    }

    private static void printTime(Calendar calendar){
        printf("AM или PM: %s%n", calendar.get(Calendar.AM_PM) == Calendar.PM ? "PM" : "AM");
        printf("Часы: %d%n", calendar.get(Calendar.HOUR));
        printf("Часы дня: %d%n", calendar.get(Calendar.HOUR_OF_DAY));
        printf("Минуты: %d%n", calendar.get(Calendar.MINUTE));
        printf("Секунды: %d%n", calendar.get(Calendar.SECOND));
    }

    private static void printf(String format, Object ... args){
        System.out.printf(format, args);
    }
}
