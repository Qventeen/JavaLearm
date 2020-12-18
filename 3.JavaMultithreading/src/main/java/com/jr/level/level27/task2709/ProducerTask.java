package com.jr.level.level27.task2709;

public class ProducerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;
    private int i = 0;

    public ProducerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ProducerTask").start();
    }

    public void run() {
        while (!stopped) {
            transferObject.put(++i);
        }
    }

    public void stop() {
        stopped = true;
    }
}
