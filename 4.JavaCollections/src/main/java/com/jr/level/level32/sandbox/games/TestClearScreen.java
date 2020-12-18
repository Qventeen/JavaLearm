package com.jr.level.level32.sandbox.games;

import java.io.IOException;



public class TestClearScreen {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world");
        System.in.read();
        //System.out.print("\033\143");
        new ProcessBuilder("clear").inheritIO().start();
        System.in.read();

        System.out.println("System console cleared");


    }
}
