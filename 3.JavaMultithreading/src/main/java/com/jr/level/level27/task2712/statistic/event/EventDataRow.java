package com.jr.level.level27.task2712.statistic.event;

import java.util.Date;

public interface EventDataRow {
    public EventType getType();

    //15.3
    public Date getDate();
    public int getTime();
}
