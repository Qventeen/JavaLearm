package com.jr.level.level27.task2712.kitchen;

import com.jr.level.level27.task2712.ConsoleHelper;
import com.jr.level.level27.task2712.Tablet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes = new ArrayList<>();

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public int getTotalCookingTime(){
        int time = 0;
        for(Dish d: dishes){
            time += d.getDuration();
        }
        return time;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        String result = "";
        //Если заказы есть вернуть пустую строку
        if(!dishes.isEmpty()) {
            result = String.format("Your order: %1$s of %2$s",
                    dishes.toString(),
                    tablet.toString()
            );
        }
        return result;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    /**
     * Инициализирует набор блюд из консоли планшета.
     */
    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    //Test method
    public static void main(String[] args) throws Exception {
        Order order = new Order(new Tablet(1));
        System.out.println(order.toString());
    }
}

