package com.jr.level.level39.task3913.entry;

import java.util.Iterator;

public class Box implements Iterator<String> {
    private static final String DEFAULT_SPLITTER = "\\t";
    private String logEntry = "";
    private String splitter = DEFAULT_SPLITTER;
    private int position = 0;
    private String[] elements = {};

    public Box(String logEntry) {
        this(logEntry, null);
    }

    public Box(String logEntry, String splitter){
        if(splitter != null){
            this.splitter = splitter;
        }
        if(logEntry != null){
            this.logEntry = logEntry.trim();
            elements = logEntry.split(this.splitter);
        }
    }

    //Iterator methods
    @Override
    public boolean hasNext() {
        return position < elements.length;
    }

    @Override
    public String next() {
        return getElement(position++);
    }

    //Technical methods
    private String getElement(int pos){
        if(testPosition(pos)){
            return elements[pos];
        }
        return "";
    }

    private boolean testPosition(int pos){
        if(pos < 0 || pos >= this.elements.length)
            return false;
        return true;
    }
}
