package com.jr.level.level28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private int poolCounter;
        private static AtomicInteger counter = new AtomicInteger(0);
        private AtomicInteger threadCounter = new AtomicInteger(0);

        public AmigoThreadFactory(){
            poolCounter = counter.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            String format = "%s-pool-%d-thread-%s";
            String tName = String.format(
                    format,
                    Thread.currentThread().getThreadGroup().getName(),
                    poolCounter,
                    threadCounter.incrementAndGet()
            );
            Thread thread = new Thread(r,tName);
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }

}
