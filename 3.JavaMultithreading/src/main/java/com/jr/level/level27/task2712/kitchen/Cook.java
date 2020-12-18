package com.jr.level.level27.task2712.kitchen;

import com.jr.level.level27.task2712.ConsoleHelper;
import com.jr.level.level27.task2712.statistic.StatisticManager;
import com.jr.level.level27.task2712.statistic.event.CookedOrderEventDataRow;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    //private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Cook(String name) {
        this.name = name;
    }

    //Setter
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

//    //Getter
//    public boolean isBusy() {
//        return busy;
//    }

    public void startCookingOrder(Order order) throws InterruptedException {
//        busy = true;
        //Задержка при приготовлении заказа
        Thread.sleep(10 * order.getTotalCookingTime());
        StatisticManager.getInstance()
                .register(new CookedOrderEventDataRow(order.getTablet().toString(),
                        name, order.getTotalCookingTime() * 60, order.getDishes()));
        ConsoleHelper.writeMessage("Start cooking - "
                + order
                + ", cooking time "
                + order.getTotalCookingTime()
                + "min");
        setChanged();
        notifyObservers(order);
//        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Order tmp;
        try {
            while (true) {
                tmp = this.queue.poll();
                if (tmp != null) {
                    this.startCookingOrder(tmp);
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
