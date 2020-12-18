package com.jr.level.level19.task1920;

/* 
Самый богатый
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) return;
        
        BufferedReader fin = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> map = new HashMap<>();
        while(fin.ready()){
            String[] tmp = fin.readLine().split("\\s");
            double d = Double.valueOf(tmp[1]);
            if(map.containsKey(tmp[0])) {
                map.put(tmp[0], map.get(tmp[0]) + d);
            } else {
                map.put(tmp[0], d);
            }
        }
        fin.close();
        Map.Entry<String, Double> max = map.entrySet().iterator().next();
        for(Map.Entry<String, Double> pair: map.entrySet()){
            if(max.getValue() < pair.getValue()){
                max = pair;
            }
        }
        for(Map.Entry<String, Double> pair: map.entrySet()){
            if(max.getValue().equals(pair.getValue())){
                System.out.println(pair.getKey());
            }
        }


    }
}
