package com.jr.level.level39.task3913.entry;

import com.jr.level.level39.task3913.Event;
import com.jr.level.level39.task3913.Status;
import java.util.Date;

public class LogEntry implements Entry {
    private String ip;
    private String name;
    private long date;
    private Event event;
    private int taskNumber;
    private Status status;

    @Override
    public String getIP() {
        return ip;
    }

    @Override
    public void setIP(String ip) {
        this.ip = ip;
    }

    @Override
    public String getUser() {
        return name;
    }

    @Override
    public void setUser(String name) {
        this.name = name;
    }

    @Override
    public Date getDate() {
        return new Date(date);
    }

    @Override
    public void setDate(Date date) {
        this.date = date.getTime();
    }

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int getTask() {
        return taskNumber;
    }

    @Override
    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntry logEntry = (LogEntry) o;

        if (date != logEntry.date) return false;
        if (taskNumber != logEntry.taskNumber) return false;
        if (ip != null ? !ip.equals(logEntry.ip) : logEntry.ip != null) return false;
        if (name != null ? !name.equals(logEntry.name) : logEntry.name != null) return false;
        if (event != logEntry.event) return false;
        return status == logEntry.status;
    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (date ^ (date >>> 32));
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + taskNumber;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
