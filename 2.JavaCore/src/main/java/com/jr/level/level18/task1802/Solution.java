package com.jr.level.level18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        int min = Integer.MAX_VALUE;
        int tmp;
        while(fin.available() > 0){
            tmp = fin.read();
            min = tmp < min? tmp: min;
        }
        System.out.println(min);
        fin.close();
    }
}
