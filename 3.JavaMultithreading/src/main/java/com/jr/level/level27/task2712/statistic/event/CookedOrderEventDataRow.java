package com.jr.level.level27.task2712.statistic.event;

import com.jr.level.level27.task2712.kitchen.Dish;
import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow {
    private Date currentDate;
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;

    /**
     * @param tabletName    -имя планшета
     * @param cookName   - имя повара
     * @param cookingTimeSeconds - время приготовления заказа в секундах
     * @param cookingDishs   - список блюд для приготовления
     */
    public CookedOrderEventDataRow(
            String tabletName,
            String cookName,
            int cookingTimeSeconds,
            List<Dish> cookingDishs)
    {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        currentDate = new Date();
    }

    //Getters
    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        //Вернуть новый объект на основании времени.
        return new Date(currentDate.getTime());
    }

    @Override
    public int getTime() {
        //Продолжительность готовки
        return this.cookingTimeSeconds;
    }

    public String getCookName() {
        return cookName;
    }
}
