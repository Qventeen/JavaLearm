package com.jr.level.level30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; !Thread.interrupted() && i < 10; i++) {
                System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
                ShareItem shareItem = new ShareItem(String.format("ShareItem-%d", i),i);
                queue.offer(shareItem);
                Thread.sleep(100);
                if (queue.hasWaitingConsumer())
                    System.out.format("Consumer в ожидании!%n");
            }
        } catch (InterruptedException e) {
        }

    }

}
