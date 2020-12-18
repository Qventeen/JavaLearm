package com.jr.level.level22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        //Read file in StringBuilder
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fname = rd.readLine();

        BufferedReader fin = new BufferedReader(new FileReader(fname));
        StringBuilder sbfin = new StringBuilder();
        while(fin.ready()){
            sbfin.append(fin.readLine());
            sbfin.append(' ');
        }
        String [] str = sbfin.toString().split("\\s+");
        StringBuilder result = getLine(str);
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) {
        //Результирующий построитель строк
        StringBuilder resultsb = new StringBuilder("");
        if(words.length == 0) return resultsb;

        //количество строк с текущим первым словом
        int ccount = 0;
        //максимальное на текущий момент количество слов последовательности
        int maxcount = 0;
        //внешний цикл перебора первых слов
        for(int k = 0; k < words.length; k++) {
            //Сделать дубликат входной последовательности
            LinkedList<String> list = new LinkedList<String>(Arrays.asList(words));
            //Построитель строк для текущего первого слова
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(k));
            sb.append(' ');
            list.remove(k);
            Character ch = Character.toUpperCase(sb.charAt(sb.length() - 2));
            for (int i = 0; i < list.size(); i++) {
                if (ch.equals(Character.toUpperCase(list.get(i).charAt(0)))) {
                    sb.append(list.get(i));
                    sb.append(' ');
                    ch = Character.toUpperCase(sb.charAt(sb.length() - 2));
                    ccount++;
                    list.remove(i);
                    i = -1;
                }
            }
            if(ccount > maxcount){
                resultsb = sb;
                maxcount = ccount;
            }
            ccount = 0;

        }
        resultsb.deleteCharAt(resultsb.length()-1);
        return resultsb;
    }
}
