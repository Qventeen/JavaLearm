package com.jr.level.level39.task3913.handlers.log;

import com.jr.level.level39.task3913.entry.Box;
import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.handlers.BaseHandler;
import java.util.regex.Pattern;

public class NameHandler extends BaseHandler<Entry, Box> {
    private Pattern pattern = Pattern.compile("(\\w|\\s)+");

    @Override
    public boolean handle(Entry entry, Box box) {
        String tmp = box.next();
        if(!pattern.matcher(tmp).matches()) {
            return false;
        }

        entry.setUser(tmp.trim());
        return handleNext(entry, box);
    }
}
