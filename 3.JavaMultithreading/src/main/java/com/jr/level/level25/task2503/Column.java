package com.jr.level.level25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        int [] sortOrder = new int[realOrder.length];
        //Инициализация
        for(int i = 0; i < sortOrder.length; i++){
            sortOrder[i] = -1;
        }
        //Назовем это зеркальный переброс
        for(int i=0,tmp=0; i < realOrder.length; i++){
            tmp = realOrder[i];
            if(tmp >= 0)
                sortOrder[tmp] = i;
        }
        Column [] values = Column.values();
        for(int i=0; i < sortOrder.length; i++){
            if(sortOrder[i] >= 0)
                result.add(values[sortOrder[i]]);
        }
        return result;
    }
    
    //Реализация интерфейса
    @Override
    public String getColumnName(){
        return this.columnName;
    }
    @Override
    public boolean isShown(){
        return realOrder[ordinal()] >= 0;
    }
    
    @Override
    public void hide(){
        //Скрыть текущую колонку
        realOrder[ordinal()] = -1;
        // for(int i = ordinal()+1; i < realOrder.length; i++){
        //     realOrder[i] --; 
        // }
    }
}
