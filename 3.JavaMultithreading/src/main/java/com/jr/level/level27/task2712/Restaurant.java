package com.jr.level.level27.task2712;

import com.jr.level.level27.task2712.kitchen.Cook;
import com.jr.level.level27.task2712.kitchen.Order;
import com.jr.level.level27.task2712.kitchen.Waiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;


public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 5000;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Qenteen");
        cook2.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        List<Tablet> tablets = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);

        }
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        Thread generator = new Thread(new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL));
        Thread cookThread1 = new Thread(cook1);
        Thread cookThread2 = new Thread(cook2);
        cookThread1.setDaemon(true);
        cookThread2.setDaemon(true);

        generator.start();
        cookThread1.start();
        cookThread2.start();

        Thread.sleep(30000);
        generator.interrupt();

        //15.2
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();


    }
}
