package level.level08.task0817;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Тугаенко","Сергей");
        map.put("Рудуха","Сергей");
        map.put("Продан","Сергей");
        map.put("Василенко","Раиса");
        map.put("Петренко","Васьек");
        map.put("Петрунина","Раиса");
        map.put("Тугай","Людмила");
        map.put("Клименко","Людмила");
        map.put("Синицкая","Татьяна");
        map.put("Ларина","Татьяна");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        Iterator<HashMap.Entry<String, String>> iter1;
        Iterator<HashMap.Entry<String, String>> iter2;
        //Создаем для них же 2 переменные
        HashMap.Entry<String, String> pair1;
        HashMap.Entry<String, String> pair2;
        //получаем 1 рабочий итератор
        iter1 = map.entrySet().iterator();
        while(iter1.hasNext()){
            pair1 = iter1.next();
            //получаем 2 рабочий итератор
            iter2 = map.entrySet().iterator();
            while(iter2.hasNext()){
                pair2 = iter2.next();
                //пошагово сравниваем каждый текущий элемент соллекции со всеми остальными
                if(pair1.getKey() != pair2.getKey() && pair1.getValue().equals(pair2.getValue())){
                    //если находим то удаляем все дубликаты и переопределяем
                    //верхний итератор
                    removeItemFromMapByValue(map, pair1.getValue());
                    iter1 = map.entrySet().iterator();
                    break;
                }
            }
        }

    }
//Делать копии по моему ой как не эффективно БУ-БУ-БУ
    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//        removeTheFirstNameDuplicates(map);
//        for (HashMap.Entry<String, String> pair: map.entrySet()) {
//            System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}

