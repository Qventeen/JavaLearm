package com.jr.level.level18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        if(args.length == 0) return;

        TreeMap<Character, Integer> map = new TreeMap<>();
        try {

            BufferedInputStream fin = new BufferedInputStream(new FileInputStream(args[0]));
             try{
                byte[] buf = new byte[fin.available()];
                fin.read(buf);
                Character tmp;
                for (byte b: buf){
                    tmp = (char) b;

                    if(map.containsKey(tmp)){
                        //положить в ячейку тмп значение + 1
                        map.put(tmp, map.get(tmp) + 1);
                    } else
                        map.put(tmp,1);
                }
                for (Map.Entry<Character, Integer> pair: map.entrySet()){
                    System.out.println(pair.getKey() + " " + pair.getValue());
                }
            }finally{
                fin.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
