package com.jr.level.level13.task1318;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String fname = rd.readLine();
        FileInputStream fio = new FileInputStream(fname);
        while(fio.available() > 0)
            wr.write(fio.read());

        fio.close();
        wr.close();
        rd.close();
    }
}
