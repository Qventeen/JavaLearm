package com.jr.level.level27.task2712.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow {
    private Date currentDate;
    private int totalDuration;
    /**
     * @param totalDuration -время приготовления заказа в секундах
     */
    public NoAvailableVideoEventDataRow(int totalDuration){
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        //Вернуть новую копию текущего времени
        return new Date(currentDate.getTime());
    }

    @Override
    public int getTime() {
        //15.4 Продолжительность готовки для которой не нашлось роликов
        return totalDuration;
    }
}
