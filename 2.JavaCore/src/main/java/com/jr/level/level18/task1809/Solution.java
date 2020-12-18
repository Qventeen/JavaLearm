package com.jr.level.level18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        FileOutputStream fout = new FileOutputStream(rd.readLine());
        byte[] buf = new byte[fin.available()];
        fin.read(buf);
        fin.close();
        //костыль
        byte tmp;
        for (int i = 0, k = buf.length-1; i < k ; i++, k--) {
            tmp = buf[i];
            buf[i] = buf[k];
            buf[k] = tmp;
        }
        fout.write(buf);
        fout.close();
    }
}
