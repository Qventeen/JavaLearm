package com.jr.level.level25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    public LoggingStateThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        State currentState = null;
        State backState = null;
        do {
            currentState = thread.getState();
            if(currentState != backState){
                System.out.println(
                        currentState
                );
                backState = currentState;
                currentState = getState();
            }

        } while(currentState != State.TERMINATED);

        this.interrupt();
    }
}
