package com.jr.level.level27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {
    /**
     * Singleton
     */
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private StatisticAdvertisementManager(){}
    public static StatisticAdvertisementManager getInstance(){
        return instance;
    }


    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    /**
     * Данный метод возвращает список активных либо неактивных роликов
     * из хранилища
     * @param active - true если активные - false не активные
     * @return - Подготовленнный список роликов
     */
    public List<Advertisement> getAdvertisements(boolean active){
        List<Advertisement> list  = list = storage.list().
                stream().
                filter(e-> active == (e.getHits() > 0)).
                collect(Collectors.toList());
        return list;
    }
}
