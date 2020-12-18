package com.jr.level.level27.task2712.kitchen;

import com.jr.level.level27.task2712.Tablet;
import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    /**
     * Инициализилирует заказ псевдослучайным набором блюд.
     */
    @Override
    protected void initDishes(){
        int size = (int) (Math.random() * 5);
        Dish[] ds = Dish.values();
        dishes = new ArrayList<>();
        for(int i = 0; i < size; i++){
            dishes.add(ds[(int) (Math.random() * (ds.length-1))]);
        }


    }
}
