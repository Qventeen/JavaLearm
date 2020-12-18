package com.jr.level.level40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");

    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        Objects.nonNull(date);
        String[] dateTime = date.split("\\s+");

        if(dateTime.length == 2){
            writeDate(dateTime[0]);
            writeTime(dateTime[1]);

        } else if(dateTime[0].contains(".")){
            writeDate(dateTime[0]);
        } else if(dateTime[0].contains(":")){
            writeTime(dateTime[0]);
        }
    }

    private static void writeDate(String localDate){
        LocalDate date = LocalDate.parse(localDate, dateFormatter);
        printf("День: %d%n", date.getDayOfMonth());
        printf("День недели: %d%n", date.getDayOfWeek().getValue());
        printf("День месяца: %d%n", date.getDayOfMonth());
        printf("День года: %d%n", date.getDayOfYear());
        printf("Неделя месяца: %s%n", date.format(DateTimeFormatter.ofPattern("W")));
        printf("Неделя года: %s%n", date.format(DateTimeFormatter.ofPattern("w")));
        printf("Месяц: %d%n", date.getMonthValue());
        printf("Год: %d%n", date.getYear());
    }

    private static void writeTime(String localTime){
        LocalTime time = LocalTime.parse(localTime, timeFormatter);
        printf("AM или PM: %s%n", time.format(DateTimeFormatter.ofPattern("a")));
        printf("Часы: %s%n", time.format(DateTimeFormatter.ofPattern("K")));
        printf("Часы дня: %d%n", time.getHour());
        printf("Минуты: %d%n", time.getMinute());
        printf("Секунды: %d%n", time.getSecond());
    }

    private static void printf(String format, Object ... args){
        System.out.printf(format, args);
    }
}
