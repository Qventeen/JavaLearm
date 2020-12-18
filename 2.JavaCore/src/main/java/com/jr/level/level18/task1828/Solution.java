package com.jr.level.level18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    private static final int[] lens = new int[]{8, 30, 8, 4};
    public static void main(String[] args) throws Exception {
        if(args.length == 0) return;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        String pl = pole(args[1], lens[0]);
        BufferedReader fin = new BufferedReader(new FileReader(name));
        StringBuffer sb = new StringBuffer();
        String tmp;
        switch (args[0]){
            case "-u":
                if(args.length != 5) return;
                while(fin.ready()){
                    tmp = fin.readLine();
                    if(pl.equals(tmp.substring(0,lens[0]))){
                        sb.append(entry(args));
                    } else {
                        sb.append(tmp);
                    }
                    sb.append('\n');
                }
                break;
            case "-d":
                if(args.length != 2) return;
                while(fin.ready()){
                    tmp = fin.readLine();
                    if(!pl.equals(tmp.substring(0,lens[0]))){
                        sb.append(tmp);
                        sb.append('\n');
                    }
                }
                break;
            default:
                System.out.println("Некорректная команда");
        }
        BufferedWriter fout = new BufferedWriter(new FileWriter(name));
        sb.deleteCharAt(sb.length()-1); //удалить последний символ новой строки
        try{
            fout.write(sb.toString().toCharArray());
        }finally {
            fin.close();
            fout.close();
        }

    }

    private static String pole(String str, int len){
        if(str.length() >= len){
            return str.substring(0,len);
        }
        StringBuffer sb = new StringBuffer(str);
        for (int i = str.length(); i < len ; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
    //построить строку по заданным аргументам
    private static String entry(String[] str){
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < str.length; i++) {
            if(str[i].length() >= lens[i-1]){
                sb.append(str[i].substring(0,lens[i-1]));
            }else {
                sb.append(str[i]);
                for (int k = str[i].length(); k < lens[i-1]; k++) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }
}

