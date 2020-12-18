package level.level08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 01 2013"));
    }
    public static boolean isDateOdd(String date) {
        //Скажу так класс припаренный
        //Года считает по принцыпу 99 = 1999, 2013 = 113
        //Месяца считает от 0;
        //К дням добавляет 2 ???
        //Сутки == 60*60*24*1000 мс
        //Время считается в мс
        Date d = new Date(date);
        final long day = 60*60*24*1000; //мс
        long in = d.getTime() - new Date(d.getYear(),0,1).getTime();

        in = in/day+1;
        System.out.println(in);
        return (in % 2 == 0) ? false : true;
    }
}
