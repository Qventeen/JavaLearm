package com.jr.level.level19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length !=2) return;
        BufferedReader fin = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fout = new BufferedWriter(new FileWriter(args[1]));
        StringBuffer sb = new StringBuffer();
        while(fin.ready()){
            sb.append(fin.readLine());
        }
        fin.close();
        String [] tmp = sb.toString().split(" ");
        for(String s: tmp){
            if(s.matches(".*[0-9]+.*")){
                fout.write(s);
                fout.write(' ');
            }
        }
        fout.close();
    }
}
