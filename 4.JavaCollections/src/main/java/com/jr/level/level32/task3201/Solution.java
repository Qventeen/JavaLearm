package com.jr.level.level32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        //Предположим что входящие параметры корректны

        try(RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
            long pos = Long.parseLong(args[1]);
            long seek = Math.min(raf.length(), pos);

            raf.seek(seek);
            raf.write(args[2].getBytes());
        }


    }
}
