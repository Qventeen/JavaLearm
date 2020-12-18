package com.jr.level.level13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String tmp = rd.readLine();//Считать имя файла
        FileOutputStream fout = new FileOutputStream(tmp); //Подключится к файлу
        //Подключить писателя к файлу
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(fout));
        //В цикле весь код записи
        do{
            tmp =rd.readLine();
            wr.write(tmp + "\n");

        } while(!"exit".equals(tmp));
        //Пока строка не равна выходу вносить данные в файловый поток
        rd.close();
        wr.close(); //одновременно выполняется flush
        fout.close(); //одновременно выполняется flush
    }
}
