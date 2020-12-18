package com.jr.level.level19.task1908;

/* 
Выделяем числа
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd =  new BufferedReader(new InputStreamReader(System.in));
        String nfin = rd.readLine();
        String nfout = rd.readLine();
        BufferedReader fin = new BufferedReader(new FileReader(nfin));
        BufferedWriter fout =  new BufferedWriter(new FileWriter(nfout));
        rd.close();
        String[] tmp;
        while(fin.ready()){
            tmp = fin.readLine().split("\\s");
            for(String s:tmp){
                try{
                    Integer.parseInt(s);
                    fout.write(s);
                    fout.write(' ');
                } catch (NumberFormatException e){}
            }
        }
        fin.close();
        fout.close();
    }
}
