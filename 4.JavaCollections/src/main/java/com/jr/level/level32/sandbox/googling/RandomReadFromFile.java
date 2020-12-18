package com.jr.level.level32.sandbox.googling;

import java.io.IOException;
import java.io.RandomAccessFile;


public class RandomReadFromFile {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("test.txt", "r");
        raf.seek(10000);
        String str = raf.readLine();
        raf.close();
    }
}
