package level.level08.task0815;

import java.util.HashMap;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Тугаенко", "Сергей");
        map.put("Василенко", "Раиса");
        map.put("Тугаенкок", "Андрей");
        map.put("Петрунина", "Наталия");
        map.put("Тарасенко", "Наталия");
        map.put("Тугай", "Любовь");
        map.put("Клименко", "Дарья");
        map.put("Тугаенкинг", "Владимир");
        map.put("Петренка", "Василий");
        map.put("Кашпипский", "Василий");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
//        //Вариант 1
//        Iterator<String> iterator = map.values().iterator();
//        while(iterator.hasNext()){
//            if(name.equals(iterator.next())) count++;
//        }

        //Вариант 2
        for(String s:map.values()){
            if(name.equals(s)){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
//        //Вариант 1
//        Iterator<String> iter = map.keySet().iterator();
//        while(iter.hasNext()){
//            if(lastName.equals(iter.next())) count++;
//        }

        //Вариант 2
        for(String s:map.keySet()){
            if(lastName.equals(s)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        HashMap<String,String> map = createMap();
//        for (Map.Entry<String, String> e : map.entrySet()) {
//            System.out.println(e.getKey() + " - " + e.getValue());
//        }
    }
}
