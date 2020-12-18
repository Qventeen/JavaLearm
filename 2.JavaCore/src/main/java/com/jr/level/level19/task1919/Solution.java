package com.jr.level.level19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fin = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        while (fin.ready()){
            String[] tmp = fin.readLine().split("\\s");
            if(!map.containsKey(tmp[0])){
                map.put(tmp[0], Double.valueOf(tmp[1]));
            } else {
                map.put(tmp[0], map.get(tmp[0]) + Double.valueOf(tmp[1]));
            }
        }
        fin.close();
        for(Map.Entry<String, Double> pair: map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }
}
