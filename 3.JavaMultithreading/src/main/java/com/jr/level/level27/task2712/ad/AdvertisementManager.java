package com.jr.level.level27.task2712.ad;


import com.jr.level.level27.task2712.ConsoleHelper;
import com.jr.level.level27.task2712.statistic.StatisticManager;
import com.jr.level.level27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.jr.level.level27.task2712.statistic.event.VideoSelectedEventDataRow;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Менеджер оптимального подбора роликов
 * Находясь на каждом из планшетов выбирает подходящий
 * набор роликов из Хранилища
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    /**
     * Обрабатывает видеоролики используя доступное время в секундах
     * @param timeSeconds - принимает время показа в секундах
     */
    public AdvertisementManager(int timeSeconds){
        this.timeSeconds = timeSeconds;
    }

    /**
     * Занимается обработкой рекламных видеороликов
     */
    public void processVideos() {

        //6. Подготовить список роликов с положительным количеством просмотров
        List<Advertisement> advertisementList = storage.list().
                stream().
                filter(e->e.getHits()>0).
                collect(Collectors.toList());

        //2,3 Получить набор неповторяющихся комбинаций
        //2. Общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа.
        List<AdvertisementSeq> compilation = getCombinations(advertisementList);

        if(compilation.isEmpty()){
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }
        //Получить набор с максимальной выгодой
        //Пункт 1, 4, 4.1, 4.2
        AdvertisementSeq advSeq = compilation.stream().max(
                Comparator.comparingLong(
                        AdvertisementSeq::getAmountPerOneDisplaying
                ).thenComparing(
                        AdvertisementSeq::getDuration
                ).thenComparing(
                        Comparator.comparingInt(AdvertisementSeq::getSize).reversed()
                )
        ).get();

        //2.4 Отобразить ролики собранные для показа в порядке уменьшения стоимости в копейках
        //2.4 Вторичная сортировка - по увеличению одной секунды ролика в тысячних долей копейки
        Collections.sort(advSeq.getAdvertisements(),
                Comparator.
                        comparingLong(
                                Advertisement::getAmountPerOneDisplaying)
                .reversed()
                .thenComparing(Advertisement::getAmountPerSecond)
        );

        //Регистрируем событие Видео выбрано
        StatisticManager.getInstance().register(
                new VideoSelectedEventDataRow(
                        advSeq.getAdvertisements(),
                        advSeq.getAmountPerOneDisplaying(),
                        advSeq.getDuration()
                )
        );

        //Отобразить подготовленный набор роликов
        for(Advertisement a: advSeq.getAdvertisements()){
            a.revalidate();
            String string = String.format("%s is displaying... %d, %d",
                a.getName(),
                a.getAmountPerOneDisplaying(),
                a.getAmountPerSecond()
            );
            ConsoleHelper.writeMessage(string);
            //First Video is displaying... 50, 277
        }
    }

    /**
     * Возвращает неповторяющиеся комбинации размером 1...n хранилища вариантов
     * @return - Вычисленные комбинации
     */
    private List<AdvertisementSeq> getCombinations(List<Advertisement> stor) {
        List<AdvertisementSeq> combinations = new LinkedList<>();
        getCombinations(0,0,new LinkedList<>(),combinations,stor);
        return combinations;
    }

    /** Даный метод производит вычисление всех неповторяющихся комбинаций
     *  наполняя ими хранилище комбинаций
     *
     * @param start - начало последовательности
     * @param range  - покрываемый диапазон
     * @param currentComb - текущая комбинация
     * @param combinations - хранилище комбинаций, возвращаемое значение
     * @param storage - хранилище элементов комбинаций
     */
    private void  getCombinations(
            int start,
            int range,
            List<Advertisement> currentComb,
            List<AdvertisementSeq> combinations,
            List<Advertisement> storage
    )
    {
        for(int i = start+range; i < storage.size(); i++ ){
            List<Advertisement> tmp = new LinkedList<>(currentComb); //создать список на основе входящего
            tmp.add(storage.get(i)); // добавить переменный элемент
            AdvertisementSeq seq = new AdvertisementSeq(tmp); //Поместить список в поледовательность
            //Если время заказа больше или равно времени текущей подборки
            //Добавить подборку в набор и нырнуть поглубже
            if(timeSeconds >= seq.getDuration()){
                combinations.add(seq); // добавить список
                getCombinations(start,i+1,tmp,combinations, storage);
            }
        }
    }


    /**
     * Вспомогательный класс.
     * Нужен для хранения и получения информации о наборе видеороликов
     */
    private class AdvertisementSeq {
        private List<Advertisement> advertisements = null;
        private int duration = -1;
        private long amountPerOneDisplaying = -1;

        private AdvertisementSeq(List<Advertisement> list) {
            if(list == null){
                this.advertisements = Collections.EMPTY_LIST;
            }else{
                this.advertisements = list;
            }
        }

        private List<Advertisement> getAdvertisements() {
            return advertisements;
        }

        private int getDuration() {
            if(duration < 0) {
                //this.duration = advertisements.stream().mapToInt(Advertisement::getDuration).sum();
                duration = 0;
                for(Advertisement adv: advertisements){
                    duration += adv.getDuration();
                }
            }
            return duration;
        }

        private long getAmountPerOneDisplaying() {
            if(amountPerOneDisplaying < 0) {
                //this.amountPerOneDisplaying = advertisements.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
                amountPerOneDisplaying = 0;
                for(Advertisement adv: advertisements){
                    amountPerOneDisplaying += adv.getAmountPerOneDisplaying();
                }
            }
            return amountPerOneDisplaying;
        }

        private int getSize() {
            return advertisements.size();
        }
    }


    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Test " + AdvertisementManager.class.getSimpleName() );
        AdvertisementManager ad = new AdvertisementManager(9*60);
        ad.processVideos();

    }


}
