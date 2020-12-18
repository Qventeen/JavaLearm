package com.jr.level.level19.task1910;

/* 
Пунктуация
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String nfin = rd.readLine();
        String nfout = rd.readLine();
        rd.close();
        rd = new BufferedReader(new FileReader(nfin));
        BufferedWriter fout = new BufferedWriter(new FileWriter(nfout));


        String[] tmp;
        while (rd.ready()){
            tmp = rd.readLine().split("[\\p{Punct}\n]+");
            for(String s: tmp){
                fout.write(s);
            }
        }
        rd.close();
        fout.close();
    }
}
