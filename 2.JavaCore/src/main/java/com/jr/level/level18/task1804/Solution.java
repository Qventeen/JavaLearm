package com.jr.level.level18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        rd.close();
        HashMap<Integer,Integer> map = new HashMap<>();
        int tmp;
        //Считать файлы в словарь
        while(fin.available() > 0){
            tmp = fin.read();
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        fin.close();
        
        Integer min = Collections.min(map.values());
        for(Map.Entry<Integer, Integer> pair: map.entrySet()){
            if(min.equals(pair.getValue())){
                System.out.print(pair.getKey() + " ");
            }
        }

    }
}
