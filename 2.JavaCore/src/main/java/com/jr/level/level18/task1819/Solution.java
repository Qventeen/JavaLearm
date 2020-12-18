package com.jr.level.level18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        try {
            //открываем 2 файла для чтения
            String name1 = rd.readLine();
            String name2 = rd.readLine();
            BufferedInputStream fin1 = new BufferedInputStream(new FileInputStream(name1));
            byte[] buf1 = new byte[fin1.available()];
            fin1.read(buf1);
            fin1.close();
            BufferedInputStream fin2 = new BufferedInputStream(new FileInputStream(name2));
            BufferedOutputStream fout1 = new BufferedOutputStream(new FileOutputStream(name1));

            while (fin2.available() > 0) {
                fout1.write(fin2.read());
            }
            fout1.write(buf1);
            fin2.close();
            fout1.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }





    }
}
