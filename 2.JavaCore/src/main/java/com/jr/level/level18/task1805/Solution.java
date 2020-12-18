package com.jr.level.level18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        Set<Integer> set = new TreeSet<>();
        while(fin.available() > 0){
            set.add(fin.read());
        }
        fin.close();
        for(Integer value: set){
            System.out.print(value + " ");
        }
    }
}
