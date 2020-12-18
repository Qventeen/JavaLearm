package level.level08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Vasilendo", new Date("JULY 30 1985"));
        map.put("Tugaenko", new Date("SEPTEMBER 1 1986"));
        map.put("Petrenko", new Date("OCTOBER 21 1999"));
        map.put("Gaponenko", new Date("MARCH 10 2003"));
        map.put("Puk", new Date("AUGUST 15 2005"));
        map.put("Guk", new Date("MAY 3 1995"));
        map.put("Tuk", new Date("DECEMBER 12 2001"));
        map.put("Tak", new Date("JULY 15 2005"));
        map.put("Rak", new Date("NOVEMBER 13 1986"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //Получаем запись каждого члена поочередно
        //Берем месяц рождения и проверяем
        //Если летний удаляем
        //Думаю операция удаления должна отражатся в итераторе нужно проверить
        String tmp;
        int month;
        Iterator<HashMap.Entry<String, Date>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            month = iter.next().getValue().getMonth();
           // System.out.println(month);
            if(month > 4 && month < 8){
                iter.remove();
            }
        }

    }

    public static void main(String[] args) {
//        HashMap<String, Date> map = createMap();
//        removeAllSummerPeople(map);
//        for (HashMap.Entry<String, Date> pair : map.entrySet()){
//            System.out.println(pair.getKey() + " - " + pair.getValue());
//        }
    }
}
