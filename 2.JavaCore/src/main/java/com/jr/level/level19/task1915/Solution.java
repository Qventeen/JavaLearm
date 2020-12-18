package com.jr.level.level19.task1915;

/* 
Дублируем текст
*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String nfout = rd.readLine();
        rd.close();
        PrintStream console = System.out;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bout);
        System.setOut(out);
        testString.printSomething();
        System.setOut(console);

        FileOutputStream fout = new FileOutputStream(nfout);
        fout.write(bout.toByteArray());
        fout.close();
        System.out.println(bout.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

