package level.level08.task0805;

import java.util.HashMap;
import java.util.Map;

/* 
На экране — значения!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    public static void printValues(Map<String, String> map) {
        //Как я понял Мап может возвращать
        //Колекцию ключей типа Сет;
        //Коллекцию значений типа Collection;
        //Каждый из этих типов возвращает ИТЕРАТОР ДОСТУПА
        //Думаю это интересно. Жаль не понятко как это устроено
        //Map.Entry<K.V> тип интерфейсв через который можно получить доступ к записям типа Map
        //Я так это понимаю

        //Вариант для key основан либо на записи либо на set
        //Вариант 1
        //Работа с ИТЕРАТОРОМ ЗАПИСИ
/*
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> pair = iterator.next();
            System.out.println(pair.getValue());
        }
        System.out.println("\n");
        //Вариант 2
        //Работа з ЗАПИСЬЮ
        for(Map.Entry<String, String> em: map.entrySet()){
            System.out.println(em.getValue());
        }
        System.out.println("\n");

        //Вариант 3
        //Работа с ИТЕРАТОРОМ ЗНАЧЕНИЯ (СТРОКИ)
        Iterator<String> iters = map.values().iterator();
        while (iters.hasNext()){
            System.out.println(iters.next());
        }
        System.out.println("\n");
*/

        //Вариант 4
        //Работа со значением
        for(String s: map.values()){
            System.out.println(s);
        }
    }
}
