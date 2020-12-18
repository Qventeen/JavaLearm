package com.jr.level.level19.task1914;

/* 
Решаем пример
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
        String[] ex = bout.toString().split(" ");
        int a = Integer.parseInt(ex[0]);
        int b = Integer.parseInt(ex[2]);
        int c = 0;
        switch (ex[1]){
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;

        }
        System.out.println(ex[0] + " " + ex[1] + " " + ex[2] + " = " + c);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

