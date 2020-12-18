package com.jr.level.level19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        rd.close();
        BufferedReader fin = new BufferedReader(new FileReader(name));
        StringBuffer sb = new StringBuffer();
        while(fin.ready()){
            System.out.println(new StringBuffer(fin.readLine()).reverse());
        }
        fin.close();
    }
}
