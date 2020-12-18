package com.jr.level.level32.sandbox.interview;

import java.io.IOException;
import java.io.RandomAccessFile;

public class NotExistRAF {
    public static void readFormRaf() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("text.txt","r");
        String test = raf.readLine();
        raf.close();
    }

    public static void writeToRaf() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("text.txt","rw");
        raf.writeChars("testString");
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        writeToRaf();
    }
}
