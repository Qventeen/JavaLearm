package com.jr.level.level32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        //Подготовить входные данные
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        //Выполнить операцию с файлом
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {

            //Переместится на нужно место
            raf.seek(number);
            byte[] buff = new byte[text.length()];

            //Прочитать необходимый текст
            raf.read(buff,0,text.length());
            String inText = new String(buff);

            //Подготовить результат
            byte [] result;
            if(text.equals(inText)) result = "true".getBytes();
            else result = "false".getBytes();

            //Записать результат
            raf.seek(raf.length());
            raf.write(result);
        }
    }
}
