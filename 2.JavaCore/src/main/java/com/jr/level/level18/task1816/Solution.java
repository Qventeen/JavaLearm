package com.jr.level.level18.task1816;

/* 
Английские буквы
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            System.out.println("Необходим аргумент");
            return;
        }
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));

        StringBuffer sb = new StringBuffer();
        while(rd.ready()){
        	sb.append(rd.readLine());
		}
		rd.close();
        //есть строка
		//подсчитать латинский буквы в строке
		Matcher m = Pattern.compile("[A-Z[a-z]]").matcher(sb.toString());
		int count = 0;
		while (m.find()){
			count++;
		}
		System.out.println(count);

    }
}
