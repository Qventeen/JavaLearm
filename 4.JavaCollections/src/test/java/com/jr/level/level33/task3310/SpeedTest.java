package com.jr.level.level33.task3310;

import com.jr.level.level33.task3310.Helper;
import com.jr.level.level33.task3310.Shortener;

import com.jr.level.level33.task3310.strategy.HashBiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.HashMapStorageStrategy;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date start = new Date();
        for(String string: strings){
            ids.add(shortener.getId(string));
        }
        Date end = new Date();
        return end.getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date start = new Date();
        for(Long id: ids){
            strings.add(shortener.getString(id));
        }
        Date end = new Date();
        return end.getTime() - start.getTime();


    }

    @Test
    public void testHashMapStorage(){
        //Создать 2 сокращателя с разными стратегиями
        Shortener hashMapShortener = new Shortener(new HashMapStorageStrategy());
        Shortener hashBiMapShortener = new Shortener(new HashBiMapStorageStrategy());

        //Подготовить случайные данные для тестирования
        Set<String> originStrings = new HashSet<>();
        for(int i = 0; i < 10000; i++){
            originStrings.add(Helper.generateRandomString());
        }

        //Выполнить получение идентификаторов по строкам
        Set<Long> ids = new HashSet<>();
        long hashMapTime = getTimeToGetIds(hashMapShortener, originStrings, ids);
        ids.clear();
        long hashBiMapTime = getTimeToGetIds(hashBiMapShortener, originStrings, ids);
        //Удостоверится что стратегия на базе подхода HashBiMap
        // при получении ключей по данным быстрее чем на базе HashMap
        assertTrue(hashMapTime > hashBiMapTime);

        //Провести тестирование выборки даннах по ключам
        originStrings.clear();
        hashMapTime = getTimeToGetStrings(hashMapShortener, ids, originStrings);
        originStrings.clear();
        hashBiMapTime = getTimeToGetStrings(hashBiMapShortener, ids, originStrings);
        //Удостоверится что обе стратегии при таком тестировании примерно равны
        assertEquals(hashMapTime, hashBiMapTime, 30);
    }
}


