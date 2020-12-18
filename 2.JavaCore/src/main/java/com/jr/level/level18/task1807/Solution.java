package com.jr.level.level18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());

        byte[] buf = new byte[fin.available()];
        fin.read(buf);
        rd.close();
        fin.close();

        int count = 0;
        for(byte b: buf){
            if(((byte) ',') == b){
                count++;
            }
        }
        System.out.println(count);

    }
}
