package com.jr.level.level15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //считать одну строку
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String url = rd.readLine();
        int begin = url.indexOf('?');
        //выделяем подстроку параметров
        String substring = url.substring(begin+1);

        List<String[]> list = parser(substring, "&", "=");
        out(list);


        //найти ? (начало списка параметров)
        //Выделить субстроку для работы

        //имеем рабочую субстроку
        //представим url так
        // * - дюбая символьная последовательность символ
        // ? - символ начала списка параметров
        // & - разделитель параметров
        // = - разделитель параметр - значение
        // =*? - разделитель имен параметров
        //Итак что нужно ???
        //Найти начало списка параметров
        //Разделить список на отдельные строки


    }
    public static void out(List<String[]> list){
        StringBuffer buf = new StringBuffer();
        for(String[] s: list){
            buf.append(s[0]);
            buf.append(" ");
        }
        //удалить последний пробел
        buf.delete(buf.length()-1, buf.length());
        System.out.println(buf);
        double rez;
        //проверка пар ключ значение на наличие obj
        for(String[] s : list){
            if(s[0].equals("obj")){
                try{
                    //попытка преобразовать значение в Double
                    rez = Double.parseDouble(s[1]);
                    alert(rez);
                }catch (Exception e){
                    //если исключение
                    //вывести строкой
                    alert(s[1]);
                }
            }
        }

    }

    public static List<String[]> parser(String value, String p1, String p2){
        //создаем список массивов строк
        List<String[]> list = new LinkedList<>();
        //делим спсок параметров на отдельные строки парпметр=значение
        for(String str: value.split(p1)){
            list.add(str.split(p2));
        }
        return list;
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
