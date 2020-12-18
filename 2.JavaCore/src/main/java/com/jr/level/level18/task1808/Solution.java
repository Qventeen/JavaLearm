package com.jr.level.level18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        //читаем 1 файл
        FileInputStream fin = new FileInputStream(rd.readLine());
        FileOutputStream fout1 = new FileOutputStream(rd.readLine());
        FileOutputStream fout2 = new FileOutputStream(rd.readLine());

        byte[] buf = new byte[fin.available()];
        fin.read(buf);
        fin.close();

        int lenth;
        if(buf.length % 2 !=0 )
            lenth = buf.length / 2 + 1;
        else
            lenth = buf.length / 2;
        fout1.write(buf, 0, lenth);
        fout1.close();
        //читаем 3 файл

        fout2.write(buf, lenth, buf.length- lenth);
        fout2.close();


    }
}
