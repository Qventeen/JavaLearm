package com.jr.level.level36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int counter = 0;
        for(List<V> l: map.values()){
            counter += l.size();
        }
        return counter;
    }

    @Override
    public V put(K key, V value) {
        V result = null;
        //Получить список значений
        List<V> list = map.get(key);
        //Если по данному ключу ничего нет
        if(list == null) {
            //Создаем новый контейнер для значений
            list = new ArrayList<V>();
        }

        //Если в списке уже есть значения
        if(list.size() > 0) {
            //Подготовить в результат последнее добавленное значение
            result = list.get(list.size() - 1);
        }

        //Добавить элемент в итоговый список значений
        list.add(value);

        //Если превышен лимит значений удалить самое древнее
        if(repeatCount < list.size()){
            list.remove(0);
        }
        //Обновить хранилище
        map.put(key,list);
        return result;
    }

    @Override
    public V remove(Object key) {
        V result = null;
        //Получить набор значений по ключу
        if(map.containsKey(key)) {
            List<V> list = map.get(key);
            //Если список пуст ничего не делать
            if (list.size() > 0) {
                //Если же значения в списке есть удалить самый древний элемент
                result = list.remove(0);
                if(list.size() == 0){
                    map.remove(key);
                }
            }
        }
        return result;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> elements = new ArrayList<>();
        for(List<V> value: map.values()){
            elements.addAll(value);
        }
        return elements;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
