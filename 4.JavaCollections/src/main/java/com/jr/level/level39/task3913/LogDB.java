package com.jr.level.level39.task3913;

import com.jr.level.level39.task3913.entry.Box;
import com.jr.level.level39.task3913.entry.Entry;
import com.jr.level.level39.task3913.entry.LogEntry;
import com.jr.level.level39.task3913.handlers.Handler;
import com.jr.level.level39.task3913.handlers.log.DateHandler;
import com.jr.level.level39.task3913.handlers.log.EventHandler;
import com.jr.level.level39.task3913.handlers.log.IpHandler;
import com.jr.level.level39.task3913.handlers.log.NameHandler;
import com.jr.level.level39.task3913.handlers.log.StatusHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class LogDB{
    private static final String DEFAULT_NAME_FILTER = "log";
    private final Set<String> logEntries = new HashSet<>();
    private final TreeMap<Long, Set<Entry>> entryForDate = new TreeMap<>();
    private Handler<Entry, Box> chainOfHandlers;

    public LogDB(Path path){
        loadFiles(path);
        chainPrepare();
        if(!parseLogs()){
            throw new RuntimeException("Incorrect input log entry");
        }
    }
    private void loadFiles(Path path){
        try{
            List<Path> paths = Files
                    .list(path)
                    .filter(e -> e.toFile().getName().endsWith(DEFAULT_NAME_FILTER))
                    .collect(toList());
                        for(Path p: paths){
                            try(Stream<String> strings = Files.lines(p)){
                                logEntries.addAll(strings.collect(toCollection(HashSet::new)));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

    private boolean parseLogs(){
        for(String stringLog: logEntries){
            Entry entry = new LogEntry();
            Box box = new Box(stringLog);
            if(chainOfHandlers.handle(entry, box)){
                Set<Entry> set = entryForDate.computeIfAbsent(
                        entry.getDate().getTime(),
                        k -> new HashSet<>());
                set.add(entry);
            } else{
                return false;
            }
        }
        return true;
    }

    private void chainPrepare(){
                    chainOfHandlers = new IpHandler();
                    chainOfHandlers.linkNext(new NameHandler())
                            .linkNext(new DateHandler())
                            .linkNext(new EventHandler())
                            .linkNext(new StatusHandler());
                }

    public Stream<Entry> getEntries(Date after, Date before, boolean inclusive){
                    long afterDateTime = after == null? Long.MIN_VALUE: after.getTime();
                    long beforeDatetime = before == null? Long.MAX_VALUE: before.getTime();

                    return entryForDate
                            .subMap(afterDateTime, inclusive, beforeDatetime, inclusive)
                            .values().stream().flatMap(Set::stream);
                }
}
