package com.jr.level.level19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String nfin = rd.readLine();
        rd.close();

        BufferedReader fin = new BufferedReader(new FileReader(nfin));
        String tmp;
        String[] tmps;
        int count = 0;
        while(fin.ready()){
            tmp = fin.readLine();
            tmps = tmp.split("\\W");
            for(String s: tmps){
                if(s.matches("world")) count++;
            }
        }
        System.out.println(count);
        fin.close();
    }
}
