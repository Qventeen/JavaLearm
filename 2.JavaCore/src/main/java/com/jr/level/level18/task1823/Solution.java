package com.jr.level.level18.task1823;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while(!"exit".equals(name = rd.readLine())){
            ReadThread thread = new ReadThread(name);
            thread.start();
        }
    }

    public static class ReadThread extends Thread {
        private String filename;
        public ReadThread(String fileName) {
            super(fileName);
            this.filename = fileName;
        }

        public void run() {
            HashMap<Integer, Integer> map = new HashMap<>();
            try {
                BufferedInputStream fin = new BufferedInputStream(new FileInputStream(filename));
                Integer tmp;
                //создать карту файла
                try {
                    while (fin.available() > 0) {
						tmp = fin.read();
						if (map.containsKey(tmp)) {
							map.put(tmp, map.get(tmp) + 1);
						} else
							map.put(tmp, 1);
					}
                } finally {
                    fin.close();
                }
                //найти ключ с наибольшим весом
                Map.Entry<Integer,Integer> max = map.entrySet().iterator().next();
                for(Map.Entry<Integer,Integer> pair: map.entrySet()){
                    if(max.getValue() < pair.getValue()){
                        max = pair;
                    }
                }
                //записать результатв работы нити в общий объект
                synchronized (resultMap){
                    resultMap.put(filename, max.getKey());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
