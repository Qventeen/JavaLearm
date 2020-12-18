package com.jr.level.level25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        while(!thread.isInterrupted()) {
            try {
                System.out.println(thread.getName());
                thread.sleep(100);

            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this,threadName);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();

    }
}
