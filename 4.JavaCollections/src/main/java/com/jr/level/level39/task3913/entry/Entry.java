package com.jr.level.level39.task3913.entry;

import com.jr.level.level39.task3913.Event;
import com.jr.level.level39.task3913.Status;
import java.util.Date;
import java.util.Objects;
import java.util.function.Predicate;

public interface Entry {
    FilterBuilder FB  = FilterBuilder.FILTER_BUILDER;
    String getIP();
    String getUser();
    Date getDate();
    Event getEvent();
    int getTask();
    Status getStatus();

    void setIP(String ip);
    void setUser(String name);
    void setDate(Date date);
    void setEvent(Event event);
    void setTaskNumber(int taskNumber);
    void setStatus(Status status);

    enum FilterBuilder {
        FILTER_BUILDER;

        private final Predicate<Entry> BASE_PREDICATE = b -> true;

        private Predicate<Entry> p = BASE_PREDICATE;


        public FilterBuilder ip(String ip){
            if(ip != null)
              p = p.and(e -> Objects.equals(e.getIP(), ip));
            return this;
        }

        public FilterBuilder user(String user){
            if(user != null)
               p = p.and(e -> Objects.equals(e.getUser(), user));
            return this;
        }

        public FilterBuilder date(Date date){
            if(date != null) {
              p = p.and(e -> Objects.equals(e.getDate(), date));
//                p = p.and(e -> date.getTime() == e.getDate().getTime());
            }
                return this;
        }

        public FilterBuilder event(Event event){
            if(event != null)
                p = p.and(e -> e.getEvent() == event);
            return this;
        }

        public FilterBuilder task(int number){
            if(number >= 0)
               p = p.and(e -> e.getTask() == number);
            return this;
        }

        public FilterBuilder status(Status status){
            if(status != null)
                p = p.and(e -> e.getStatus() == status);
            return this;
        }

        public Predicate<Entry> build(){
            Predicate<Entry> result = p;
            p = BASE_PREDICATE;
            return result;
        }
    }
}
