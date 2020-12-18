package com.jr.level.level27.task2712.statistic;

import com.jr.level.level27.task2712.ConsoleHelper;
import com.jr.level.level27.task2712.statistic.event.CookedOrderEventDataRow;
import com.jr.level.level27.task2712.statistic.event.EventDataRow;
import com.jr.level.level27.task2712.statistic.event.EventType;
import com.jr.level.level27.task2712.statistic.event.VideoSelectedEventDataRow;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * Синглтон
 * Даный класс собирает статистику работы приложения
 * для директора
 */
public class StatisticManager {
    private static final StatisticManager INSTANCE = new StatisticManager();

    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){ }

    /**
     * Возвращает экземпляр себя самого
     * @return
     * @notnull
     */
    public static StatisticManager getInstance(){
            return INSTANCE;
    }

    /**
     * Регистрирует события для статистики
     * @param data - поступающее извне событие
     */
    public void register(EventDataRow data){
        statisticStorage.put(data);
    }


    /**
     * Делает выборку и выводит на в консоль
     * статистическую информацию о показаных рекламных роликах
     */
    public void getShowedVideoStatistic(){
        //Получить список событий "Видео выбрано" роликов
        List<EventDataRow> dataRowsList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        //Групировать статистику просмотров
        //Групировка выполняется по дате создания записи
        //Каждому ключу-дате соответствует значение собранных денег за просмотры
        Map<Long,Double> map = dataRowsList.stream().collect(Collectors.groupingBy(
                e -> getDateWithoutTime(e.getDate()), //Производим групировку по дате путем обрезки времени
                () -> new TreeMap<Long,Double>(Comparator.reverseOrder()), //Конструктор для хранилища
                //Нисходящий коллектор для получения значений
                Collectors.summingDouble(e->((VideoSelectedEventDataRow) e).getAmount()/100.0))
        );

        //Подготовка к форматированному выводу
        SimpleDateFormat sDF = new SimpleDateFormat("dd-MMM-yyyy",Locale.US);
        String formatString = "%s - %.2f";
        double sum = 0;
        //Вывести информацию в консоль
        for(Map.Entry<Long,Double> entry :map.entrySet()){
            ConsoleHelper.writeMessage(
                    String.format(
                            Locale.US,formatString,sDF.format(new Date(entry.getKey())),entry.getValue()
                    )
            );
            sum += entry.getValue();
        }
        String totalString = "Total - %.2f";
        ConsoleHelper.writeMessage(String.format(Locale.US,totalString, sum));
    }

    /**
     * Даный метод подготваливает и
     * выводит статистику загрузки поваров
     */
    public void getCookWorkloading(){
        //Получить список событий нужного типа
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.COOKED_ORDER);

        //Сгрупирвоваить данные для статистики:
        // Дата без времени -> Имя повара -> Сумарное время работы в секундах
        // Тренеруемся работать со streamAPI
        Map<Long,Map<String,Long>> map =
                eventDataRowList.stream().collect(
                        Collectors.groupingBy(
                                e -> getDateWithoutTime(e.getDate()),
                                () -> {
                                    return new TreeMap<Long,Map<String,Long>>(Comparator.reverseOrder());
                                },
                                Collectors.groupingBy(
                                        e->((CookedOrderEventDataRow) e).getCookName(),
                                        TreeMap::new,
                                        Collectors.summingLong(EventDataRow::getTime)
                                )
                        )
                );
        //Подготовка к выводу
        SimpleDateFormat sDF = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        String entryFormat = "%s - %d min";
        //Вывод данных на экран
        for(Map.Entry<Long,Map<String,Long>> e1: map.entrySet()){
            //Вывод груповой даты
            ConsoleHelper.writeMessage(sDF.format(new Date(e1.getKey())));
            //Вывод статистики по разным поварам
            for(Map.Entry<String,Long> e2: e1.getValue().entrySet()){
                long tmp = e2.getValue();
                ConsoleHelper.writeMessage(
                        String.format(
                                Locale.US,entryFormat,
                                e2.getKey(),
                                tmp % 60 > 0 ? (tmp / 60+1) : (tmp / 60)
                        )
                );
            }
            ConsoleHelper.writeMessage("");
        }
    }

    //Конвертирует дату в локальную дату используя дату sql
    private LocalDate convertToLocalDate(Date date){
        //Создаем дату из пакета sql и преобразуем ее к локальной дате
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    //Конвертирует локальную дату в дату используя дату sql
    private Date convertToDate(LocalDate localDate){
        //Создаем java.sql.Date из LocalDate получаем точку на шкале из которой создаем объект Date
        return new Date(java.sql.Date.valueOf(localDate).getTime());
    }

    //Возвращает целочисленное представление даты с попутным урезанием времени
    private Long getDateWithoutTime(Date date){
        //По моему дороговатая операция
        return convertToDate(convertToLocalDate(date)).getTime();
    }


    /**
     * Вспомогательный внутренний класс
     * отвечает за хранение событий приложения
     */
    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage(){
            storage = new HashMap<>();
            for(EventType e: EventType.values()){
                storage.put(e,new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data){
            //Получить ссылку на список событий используя тип события
            List<EventDataRow> tmp = storage.get(data.getType());
            //Дополнить список новым событием
            tmp.add(data);
        }
        private List<EventDataRow> get(EventType eventType){
            return storage.get(eventType);
        }

    }
}
