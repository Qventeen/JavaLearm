package com.jr.level.level39.task3913.handlers.log;

import com.jr.level.level39.task3913.entry.Box;
import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.Status;
import com.jr.level.level39.task3913.handlers.BaseHandler;

public class StatusHandler extends BaseHandler<Entry, Box> {
    @Override
    public boolean handle(Entry entry, Box box) {
        Status status;
        try{
            status = Status.valueOf(box.next());
            entry.setStatus(status);
        }catch (RuntimeException r){
            return false;
        }

        return handleNext(entry, box);
    }
}
