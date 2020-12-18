package com.jr.level.level39.task3913;

import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.ql.QLEntity;
import com.jr.level.level39.task3913.ql.QLParser;
import com.jr.level.level39.task3913.query.DateQuery;
import com.jr.level.level39.task3913.query.EventQuery;
import com.jr.level.level39.task3913.query.IPQuery;

import com.jr.level.level39.task3913.query.QLQuery;
import com.jr.level.level39.task3913.query.UserQuery;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.*;
import java.util.function.Function;

import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private static final Entry.FilterBuilder FB = Entry.FilterBuilder.FILTER_BUILDER;

    private final Path basePath;
    private final LogBox logBox;

    public LogParser(Path path) {
        if(path == null || !Files.isDirectory(path)){
            throw new RuntimeException("Path not found");
        }
        this.basePath = path;
        logBox = new LogBox(basePath);
    }

    //IPQuery interface methods
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return logBox.getIpByFilter(null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return logBox.getIpByFilter(FB.user(user).build(), after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return logBox.getIpByFilter(FB.event(event).build(), after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return logBox.getIpByFilter(FB.status(status).build(), after, before);
    }

    //UserQuery interface methods
    @Override
    public Set<String> getAllUsers() {
        return logBox.getUserByFilter(null, null, null);
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return logBox.getUserByFilter(null , after, before).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return (int) logBox.getDataStream(FB.user(user).build(), after, before,true, Entry::getEvent).distinct().count();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return logBox.getUserByFilter(FB.ip(ip).build(), after, before);
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return logBox.getUserByFilter(FB.event(Event.LOGIN).build(), after, before);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return logBox.getUserByFilter(FB.event(Event.DOWNLOAD_PLUGIN).build(), after, before);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return logBox.getUserByFilter(FB.event(Event.WRITE_MESSAGE).build(), after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return logBox.getUserByFilter(FB.event(Event.SOLVE_TASK).build(), after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return logBox.getUserByFilter(FB.task(task).event(Event.SOLVE_TASK).build(), after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return logBox.getUserByFilter(FB.event(Event.DONE_TASK).build(), after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return logBox.getUserByFilter(FB.task(task).event(Event.DONE_TASK).build(), after, before);
    }

    //DateQuery interface methods
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return logBox.getDateByFilter(FB.event(event).user(user).build(), after, before);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return logBox.getDateByFilter(FB.status(Status.FAILED).build(), after, before);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return logBox.getDateByFilter(FB.status(Status.ERROR).build(), after, before);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return logBox.getFirstDateByFilter(FB.event(Event.LOGIN).user(user).build(), after, before);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return logBox.getFirstDateByFilter(
                FB.task(task).event(Event.SOLVE_TASK).user(user).build(), after, before);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return logBox.getFirstDateByFilter(
                FB.task(task).event(Event.DONE_TASK).user(user).build(), after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return logBox.getDateByFilter(FB.event(Event.WRITE_MESSAGE).user(user).build(), after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return logBox.getDateByFilter(FB.event(Event.DOWNLOAD_PLUGIN).user(user).build(), after, before);
    }

    //EventQuery implements methods
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return logBox.getEventByFilter(null, after, before);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return logBox.getEventByFilter(FB.ip(ip).build(), after, before);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return logBox.getEventByFilter(FB.user(user).build(), after, before);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return logBox.getEventByFilter(FB.status(Status.FAILED).build(), after, before);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return logBox.getEventByFilter(FB.status(Status.ERROR).build(), after, before);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) logBox.getEventStreamByFilter(
                FB.task(task).event(Event.SOLVE_TASK).build(), after, before
        ).count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) logBox.getEventStreamByFilter(
                FB.task(task).event(Event.DONE_TASK).build(), after, before
        ).count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return logBox.getTaskStatisticByEvent(Event.SOLVE_TASK, after, before);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return logBox.getTaskStatisticByEvent(Event.DONE_TASK, after, before);
    }

    @Override
    public Set<Object> execute(String query) {
        return logBox.getDataByQLQuery(query);
    }

    private static class LogBox{
        private final LogDB logDB;
        private final QLParser qlParser;

        private LogBox(Path path){
            logDB = new LogDB(path);
            qlParser = new QLParser();
        }

        //For QLQuery interface
        private Set<Object> getDataByQLQuery(String query){
            QLEntity entity = qlParser.parse(query);
            return getData(entity.getFilters(), entity.getAfter(), entity.getBefore(), false, entity.getResult(), toSet());
        }

        //For EventQuery interface
        private Map<Integer, Integer> getTaskStatisticByEvent(Event event, Date after, Date before){
            return logDB.getEntries(after, before, true).
                    filter(FB.event(event).build())
                    .collect(groupingBy(Entry::getTask, Collectors.reducing(0, e -> 1, Integer::sum)));
        }

        private Set<Event> getEventByFilter(Predicate<Entry> filter, Date after, Date before){
            return getDataStream(filter, after, before, true, Entry::getEvent).collect(toSet());
        }

        private Stream<Event> getEventStreamByFilter(Predicate<Entry> filter, Date after, Date before){
            return getDataStream(filter, after, before,true, Entry::getEvent);
        }

        //For DateQuery interface
        private Set<Date> getDateByFilter(Predicate<Entry> filter, Date after, Date before){
            return getData(filter, after, before, true, Entry::getDate, toSet());
        }

        private Date getFirstDateByFilter(Predicate<Entry> filter, Date after, Date before){
            return getDataStream(filter, after, before, true, Entry::getDate).min(Date::compareTo).orElse(null);
        }

        //For UserQuery interface
        private Set<String> getUserByFilter(Predicate<Entry> filter, Date after, Date before){
            return getData(filter, after, before, true, Entry::getUser, toSet());
        }

        //For IpQuery interface
        private  Set<String> getIpByFilter(Predicate<Entry> filter, Date after, Date before){
            return getData(filter, after, before, true, Entry::getIP, toSet());
        }

        //Common getters
        private <T, R> R getData(Predicate<Entry> filter , Date after, Date before, boolean inclusive, Function<Entry, T> function, Collector<T,?,R> collector){
            if(collector == null) throw new NullPointerException();
            return getDataStream(filter, after, before, inclusive, function).collect(collector);
        }

        private <T> Stream<T> getDataStream(Predicate<Entry> filter, Date after, Date before, boolean inclusive, Function<Entry, T> function){
            if(function == null) throw new NullPointerException();
            if(filter == null){
                return logDB.getEntries(after,before, inclusive).map(function);
            }
            return logDB.getEntries(after, before, inclusive).filter(filter).map(function);
        }

    }

}
