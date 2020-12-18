package com.jr.level.level19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bout);
        System.setOut(out);
        testString.printSomething();
        System.setOut(console);
        String[] strings = bout.toString().split("\n");
        int count = 1;
        for(String s: strings){
            System.out.println(s);
            if(count++ % 2 == 0)
                System.out.println("JR - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
