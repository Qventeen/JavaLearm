package com.jr.level.level39.task3913.ql;

import com.jr.level.level39.task3913.entry.Entry;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;

public class QLEntity {
    private Function<Entry, Object> result;
    private Predicate<Entry> filters;
    private Date after;
    private Date before;

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date after) {
        this.after = after;
    }

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date before) {
        this.before = before;
    }

    public Function<Entry, Object> getResult() {
        return result;
    }

    public void setResult(Function<Entry, Object> result){
        this.result = result;
    }

    public Predicate<Entry> getFilters() {
        return filters;
    }

    public void setFilters(Predicate<Entry> filters) {
        this.filters = filters;
    }
}
