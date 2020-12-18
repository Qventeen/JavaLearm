package com.jr.level.level39.task3913.handlers.log;

import com.jr.level.level39.task3913.entry.Box;
import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.handlers.BaseHandler;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler extends BaseHandler<Entry, Box> {
    private DateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");

    @Override
    public boolean handle(Entry entry, Box box) {
        try {
            Date dateTime = dateFormat.parse(box.next());
            entry.setDate(dateTime);
        } catch (ParseException e) {
            return false;
        }

        return handleNext(entry, box);
    }
}
