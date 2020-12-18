package com.jr.level.level27.task2712;

import com.jr.level.level27.task2712.ad.AdvertisementManager;
import com.jr.level.level27.task2712.ad.NoVideoAvailableException;
import com.jr.level.level27.task2712.kitchen.Order;
import com.jr.level.level27.task2712.kitchen.TestOrder;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private Order order;

    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Tablet(int number) {
        this.number = number;
    }

    /**
     * Создает новый заказ
     * @return возвращяет созданный заказ
     */
    public Order createOrder() {
        try {
            order = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        orderProcessing();
        return order;
    }

    /**
     * Создает тестовый заказ
     * наполненный случайными блюдами
     */
    public void createTestOrder(){
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        orderProcessing();
    }


    //Вспомогательный метод выполняющий обработку заказа после создания
    private void orderProcessing() {
        ConsoleHelper.writeMessage(order.toString());
        if (!order.isEmpty()) {
            try {
                queue.put(order);
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            } catch (NoVideoAvailableException e) {
                //Лог о недоступности видео для рекламмы
                logger.log(Level.INFO, "No video is available for the order " + order);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    //Setter
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }

}
