package com.jr.level.level18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        rd.close();
        //Для фиксации количества каждого байта нужно фиксировать его появление
        //Для этого отлично подойдет Словарь
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer tmp;
        while(fin.available() > 0){
            tmp = fin.read(); //автоупаковка
            if(map.get(tmp) == null){
                map.put(tmp,1);
            } else {
                map.put(tmp, map.get(tmp) + 1); //автораспаковка и упаковка
            }
        }
        fin.close();

        //Создать контрольную запись
        Map.Entry<Integer, Integer> pairMax =
                map.entrySet().iterator().next();
        //Найти запись с максимальным значением
        for(Map.Entry<Integer, Integer> pair: map.entrySet()){
            if(pairMax.getValue() < pair.getValue() ){
                pairMax = pair;
            }
        }
        //Отобразить ключи записей == макс значению
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(pairMax.getValue().equals(e.getValue())){
                System.out.print(e.getKey() + " ");
            }
        }
    }
}
