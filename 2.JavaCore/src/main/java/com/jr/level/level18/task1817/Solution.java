package com.jr.level.level18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        if(args.length == 0) return;

        BufferedReader fin = new BufferedReader(new FileReader(args[0]));
        StringBuffer sb = new StringBuffer();
        while (fin.ready()) sb.append(fin.readLine());
        fin.close();
        Matcher matcher = Pattern.compile("\\s").matcher(sb.toString());
        double cspaces = 0;
        while(matcher.find()) cspaces+=1;
        double rez = cspaces / sb.length() * 100;
        rez = new BigDecimal(rez).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(rez);
    }
}
