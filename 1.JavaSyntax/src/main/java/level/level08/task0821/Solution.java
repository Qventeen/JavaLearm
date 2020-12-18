package level.level08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Тугаенко","Сергей");
        map.put("Тугаенко","Андрей");
        map.put("Тугаенко","Артем");
        map.put("Василенко","Рая");
        map.put("Рудуха","Сергей");
        map.put("Продан","Сергей");
        map.put("Петренко","Анастасия");
        map.put("Василенко","Анастисия");
        map.put("Тугай","Андрей");
        map.put("Петруненко","Андрей");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
