package com.jr.level.level39.task3913.ql;

import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.Event;
import com.jr.level.level39.task3913.Status;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jr.level.level39.task3913.entry.Entry.FB;

public class QLParser {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
    private Pattern pattern = Pattern.compile("get (ip|user|date|event|status)"
            + "( for (ip|user|date|event|status) = \"(.*?)\")?"
            + "( and date between \"(.*?)\" and \"(.*?)\")?");

    public QLEntity parse(String query){
        String field1, field2 = null, value1 = null;
        Date after = null, before = null;
        Matcher matcher = pattern.matcher(query);
        matcher.find();
        field1 = matcher.group(1);
        if (matcher.group(2) != null) {
            field2 = matcher.group(3);
            value1 = matcher.group(4);
            if (matcher.group(5) != null) {
                after = getDate(matcher.group(6));
                before = getDate(matcher.group(7));
            }
        }
        QLEntity entity = new QLEntity();
        entity.setResult(getResultFunction(field1));
        entity.setFilters(getFilter(field2, value1));
        entity.setAfter(after);
        entity.setBefore(before);
        return entity;
    }

    private Function<Entry, Object> getResultFunction(String string){
        Function<Entry, Object> function = null;
        try {
            QLField result = QLField.valueOf(string.toUpperCase());
            switch (result){
                case IP: function = Entry::getIP; break;
                case USER: function = Entry::getUser; break;
                case DATE: function = Entry::getDate; break;
                case EVENT: function = Entry::getEvent; break;
                case STATUS: function = Entry::getStatus; break;
            }

        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return function;
    }

    private Predicate<Entry> getFilter(String key, String value){
        if(value == null || key == null) return null;
        try {
            QLField keyField = QLField.valueOf(key.toUpperCase());
            switch (keyField){
                case IP: FB.ip(value); break;
                case USER: FB.user(value); break;
                case DATE: FB.date(simpleDateFormat.parse(value)); break;
                case EVENT: FB.event(Event.valueOf(value.toUpperCase())); break;
                case STATUS: FB.status(Status.valueOf(value.toUpperCase()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return FB.build();
    }

    private Date getDate(String date){
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
        }
        return null;
    }






}
