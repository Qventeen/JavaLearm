package com.jr.level.level32.sandbox.googling;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RandomWriteToFile {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        int N = (int) Math.random() * 10000;
        raf.seek(N);
        raf.writeChars("Hello world!");
        raf.close();
    }

}

class ReadFromLittleFile {
    public static void main(String[] args) throws IOException {
        int N = 100;
        String lineN = Files.readAllLines(Paths.get("test.txt")).get(N);
    }
}

class ReadFromBigFile {
    public static void main(String[] args) throws IOException {
        int N = 100;
        String lineN = Files.lines(Paths.get("test.txt")).skip(N-1).findFirst().get();

    }
}
