package com.jr.level.level14.task1419;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        //1 арифметика
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //2 null reference
        try {
            Object o = null;
            o.toString();
        } catch (Exception e){
            exceptions.add(e);
        }
        //3 invalid range
        try {
            int[] n = new int[1];
            int a = n[1];
        } catch (Exception e){
            exceptions.add(e);
        }
        //4 illegal cast
        try {
            String s = new String();
            Object o = s;
            Integer i = (Integer) o;
        } catch (Exception e){
            exceptions.add(e);
        }
        //5 number format exception
        try {
            Integer n = new Integer("серега");

        }catch (Exception e){
            exceptions.add(e);
        }
        //6 ClassNotFoundException
        try {
            Class.forName("Classggg");
        }catch (Exception e){
            exceptions.add(e);
        }
        //7 бросок исключения ввода вывода
        try {
            throw  new IOException();
        } catch (Exception e){
            exceptions.add(e);
        }
        //8 FileNotFoundException
        try {
            new FileInputStream("afadf");
        } catch (Exception e){
            exceptions.add(e);
        }
        //9 ArrayStoreException
        try {
            Object[] o = new String[3];
            o[1] = new Integer(20);
        } catch (Exception e) {
           exceptions.add(e);
        }
        //10 RuntimeException()
        try {
            throw new RuntimeException();
        } catch (Exception e){
            exceptions.add(e);
        }


        //напишите тут ваш код

    }
}
