package com.jr.level.level33.task3310;

import com.jr.level.level33.task3310.strategy.DualHashBidiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.FileStorageStrategy;
import com.jr.level.level33.task3310.strategy.HashBiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.HashMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.OurHashBiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.OurHashMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.StorageStrategy;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static com.jr.level.level33.task3310.Helper.*;

public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        StorageStrategy strategy2 = new OurHashMapStorageStrategy();
        StorageStrategy strategy3 = new FileStorageStrategy();
        StorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        StorageStrategy strategy5 = new HashBiMapStorageStrategy();
        StorageStrategy strategy6 = new DualHashBidiMapStorageStrategy();

        testStrategy(strategy, 1000);
        testStrategy(strategy2, 1000);
        testStrategy(strategy3, 1000);
        testStrategy(strategy4, 1000);
        testStrategy(strategy5, 1000);
        testStrategy(strategy6, 1000);
    }


    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> keys = new HashSet<>();
        strings.forEach(e -> keys.add(shortener.getId(e)));
        return keys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        keys.forEach(e -> strings.add(shortener.getString(e)));
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        printMessage(strategy.getClass().getSimpleName());

        //Подготовить сокращатель
        Shortener shortener = new Shortener(strategy);

        //Подготовить коллекции для теста
        Set<String> values = new HashSet<>();

        //Сгенерировать тестовое множество строк
        for(long num = 0; num < elementsNumber; num++ ){
            values.add(generateRandomString());
        }

        Set<Long> testKeys;
        Set<String> testValues;
        testKeys = timeTest(() -> getIds(shortener, values));
        testValues = timeTest(() -> getStrings(shortener, testKeys));

        boolean flag = values.size() == testValues.size();

        printMessage(flag ? "Тест пройден." : "Тест не пройден.");
    }

    private static <T> T timeTest(Supplier<T> supplier){
        Date start = new Date();
        T result = supplier.get();
        Date end = new Date();
        printMessage(String.valueOf((end.getTime() - start.getTime())));
        return result;
    }

}
