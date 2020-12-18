package com.jr.level.level25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler( new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String s = "Поживем - увидим";
                if(e instanceof Error){
                    s = "Нельзя дальше работать";
                }
                else if (e instanceof Exception){
                    s = "Надо обработать";
                }
                System.out.println(s);
            }
        }
        );
    }


    public static void main(String[] args) {
    }
}
