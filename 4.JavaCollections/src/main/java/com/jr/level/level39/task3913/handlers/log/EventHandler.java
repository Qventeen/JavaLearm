package com.jr.level.level39.task3913.handlers.log;

import com.jr.level.level39.task3913.entry.Box;
import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.Event;
import com.jr.level.level39.task3913.handlers.BaseHandler;

public class EventHandler extends BaseHandler<Entry, Box> {
    @Override
    public boolean handle(Entry entry, Box box) {
        Event event;
        try{
            String[] tmp = box.next().split("\\s");
            event = Event.valueOf(tmp[0].toUpperCase());
            entry.setEvent(event);

            switch (event){
                case DONE_TASK:
                case SOLVE_TASK:
                    int numberOfTask = Integer.parseInt(tmp[1]);
                    entry.setTaskNumber(numberOfTask);
                    break;
            }
        }catch (RuntimeException r){
            return false;
        }

        return handleNext(entry, box);
    }
}
