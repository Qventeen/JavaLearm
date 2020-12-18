package com.jr.level.level27.task2712.statistic.event;

import com.jr.level.level27.task2712.ad.Advertisement;
import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {
    private Date currentDate;
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;

    /**
     * Конструктор
     * @param optimalVideoSet   - список видео-роликов, отобранных для показа
     * @param amount            - сумма денег в копейках
     * @param totalDuration     - общая продолжительность показа отобранных рекламных роликов
     */
    public VideoSelectedEventDataRow(
            List<Advertisement> optimalVideoSet,
            long amount,
            int totalDuration)
    {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    //Getters
    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        //Дата создания события
        return new Date(currentDate.getTime());
    }

    @Override
    public int getTime() {
        //Вернуть длительность текущего набора видео
        return totalDuration;
    }

    public long getAmount() {
        return amount;
    }
}
