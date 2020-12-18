package com.jr.level.level18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        int max = Integer.MIN_VALUE;
        int tmp;
        while(fin.available()>0){
            tmp = fin.read();
            max = max < tmp ? tmp : max;
        }
        System.out.println(max);
        fin.close();
    }
}
