package com.jr.level.level19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        System.out.println(0 % 2);
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String nfin = rd.readLine();
        String nfout = rd.readLine();
        BufferedReader fin = new BufferedReader(new FileReader(nfin));
        BufferedWriter fout =  new BufferedWriter(new FileWriter(nfout));
        rd.close();
        int i = 1;
        int tmp;
        while(fin.ready()){
            tmp = fin.read();
            if(i % 2 == 0)
                fout.write((char) tmp);
            i++;
        }

        fin.close();
        fout.close();
    }
}
