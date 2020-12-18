package com.jr.level.level27.task2712.ad;

/**
 * Рекламное объявление
 * Содержит информацию о рекламных объявлениях
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    /**
     * Стоимость одного показа в копейках
     */
    private long amountPerOneDisplaying;

    /**
     * Создает объект рекламного объявления
     * @param content - содержит рекламное видео
     * @param name - имя рекламного ролика
     * @param initialAmount - стоимость рекламы в копейках
     * @param hits - количество оплаченых показов
     * @param duration - продолжительность ролика в секундах
     */
    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits>0?initialAmount/hits:0;
    }

    //Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void setAmountPerOneDisplaying(long amountPerOneDisplaying) {
        this.amountPerOneDisplaying = amountPerOneDisplaying;
    }

    //Actions
    public void revalidate(){
        if(hits <= 0) throw new UnsupportedOperationException();
        hits--;
    }

    //Test getter
    public int getHits(){
        return hits;
    }

    public long getAmountPerSecond(){
        return getAmountPerOneDisplaying()*1000/getDuration();
    }
}
