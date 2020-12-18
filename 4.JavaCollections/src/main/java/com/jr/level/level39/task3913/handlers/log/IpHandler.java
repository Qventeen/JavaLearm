package com.jr.level.level39.task3913.handlers.log;

import com.jr.level.level39.task3913.entry.Box;
import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.handlers.BaseHandler;
import java.util.regex.Pattern;


public class IpHandler extends BaseHandler<Entry, Box> {
    private Pattern pattern = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");
    @Override
    public boolean handle(Entry entry, Box box) {
        String block = box.next();
        if(!pattern.matcher(block).matches())
            return false;

        entry.setIP(block);

        return handleNext(entry, box);
    }
}
