package com.jr.level.level19.task1913;

/* 
Выводим только цифры
*/


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bout);
        System.setOut(out);
        testString.printSomething();
        System.setOut(console);
        //преобразование вывода
        StringReader sr = new StringReader(bout.toString());
        String str = bout.toString();
        str = str.replaceAll("[^1-9]", "");
        System.out.println(str);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
