package com.jr.level.level27.task2712;

import com.jr.level.level27.task2712.ad.Advertisement;
import com.jr.level.level27.task2712.ad.StatisticAdvertisementManager;
import com.jr.level.level27.task2712.statistic.StatisticManager;
import java.util.Comparator;

/**
 * Даный класс реализует упрощенный интерфейс
 * статистической отчетности для директора
 */
class DirectorTablet {
    /**
     * Выводит в консоль статистику прибыли от показа рекламы
     */
    void printAdvertisementProfit(){
        StatisticManager.getInstance().getShowedVideoStatistic();
    }

    /**
     * Выводит в консоль статистику загруженности поваров
     */
    void printCookWorkloading(){
        StatisticManager.getInstance().getCookWorkloading();
    }

    /**
     * Отображает в консоли отсортированый список активных рекламных роликов
     */
    void printActiveVideoSet(){
        StatisticAdvertisementManager.getInstance()
                .getAdvertisements(true)
                .stream()
                .sorted(Comparator.comparing(Advertisement::getName,String::compareToIgnoreCase))
                .forEach(e-> ConsoleHelper
                        .writeMessage(String.format("%s - %d",e.getName(),e.getHits()))
                );
    }

    /**
     * Отображает в консоли отсортированый список неактивных рекламных роликов
     */
    void printArchivedVideoSet(){
        StatisticAdvertisementManager.getInstance().getAdvertisements(false)
                .stream()
                .sorted(Comparator.comparing(Advertisement::getName,String::compareToIgnoreCase))
                .map(Advertisement::getName)
                .forEach(ConsoleHelper::writeMessage);
    }
}
