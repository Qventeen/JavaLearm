package com.jr.level.level19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        if(args.length < 2) return;
        BufferedReader fin = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fout = new BufferedWriter(new FileWriter(args[1]));
        StringBuffer sb = new StringBuffer();
        String[] words;
        try {
            while(fin.ready()){
				words = fin.readLine().split(" ");
				for(String s: words){
					if(s.length() > 6){
						sb.append(s);
						sb.append(',');
					}
				}
				//sb.append('\n');
			}
			sb.deleteCharAt(sb.length()-1);
            //sb.delete(sb.length()-2, sb.length());
            fout.write(sb.toString());
        } finally {
            fin.close();
            fout.close();
        }
    }
}
