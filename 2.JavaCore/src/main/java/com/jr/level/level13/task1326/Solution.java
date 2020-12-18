package com.jr.level.level13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/*
Сортировка четных чисел из файла
*/
//Делаю все максимально просто но без проверок
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> list = new LinkedList<>();
        //Получить имя файла
        String name = rd.readLine();
        //Открыть файловый поток
        FileInputStream fin = new FileInputStream(name);
        //Привязать поток к ридеру
        rd = new BufferedReader(new InputStreamReader(fin));

        //заполнения списка
        String tmp = rd.readLine();
        Integer ntmp;
        while (tmp != null){
            ntmp = Integer.parseInt(tmp); //входная строка не проверяется на корректность формата
            if( ntmp % 2 == 0 ){ //автораспаковка
                list.add(ntmp); //добавление элементов в связанный список за время const
            }
            tmp = rd.readLine();
        }
        rd.close();
        fin.close();
        //Копируем список в массив для увеличения производительости сортировки
        //Связанный список сортируется медленно
        ArrayList<Integer> array = new ArrayList<Integer>(list);
        array.sort(Comparator.naturalOrder());

        for(Integer n: array){
            System.out.println(n);
        }
    }
}
