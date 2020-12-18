package com.jr.level.level25.task2512;

import java.util.LinkedList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        searchStackException(e);
        for(Throwable th: causes ){
            System.out.println(th.getClass().getName() + ": " + th.getMessage());
        }

    }
    private List<Throwable> causes = new LinkedList<>();
    private void searchStackException(Throwable e){
        if(e.getCause() != null){
            searchStackException(e.getCause());
        }
        causes.add(e);
    }

    public static void main(String[] args) {
    }
}
