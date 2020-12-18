package com.jr.level.level27.task2712;

import java.util.List;

/**
 * Генератор случайных заказов
 */
public class RandomOrderGeneratorTask implements Runnable {
    private final List<Tablet> tabletsList;
    private final int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval){
        this.tabletsList = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        Tablet currentTablet;
        try{
            while(true){
                currentTablet = tabletsList.get((int) (Math.random() * (tabletsList.size()-1)));
                currentTablet.createTestOrder();
                Thread.sleep(interval);
            }
        }catch (InterruptedException e){}

    }


}
