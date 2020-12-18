package com.jr.level.level15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0, "Serege");
        labels.put(2.0, "Raya");
        labels.put(3.0, "Nastya");
        labels.put(4.0, "Volodya");
        labels.put(5.0, "Rostick");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
