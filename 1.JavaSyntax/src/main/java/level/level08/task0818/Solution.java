package level.level08.task0818;

import java.util.HashMap;
import java.util.Iterator;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Тугаенко", 5000 );
        map.put("Василенко", 3000 );
        map.put("Петренко", 500 );
        map.put("Петруненко", 300 );
        map.put("Продан", 250 );
        map.put("Семенюк", 275 );
        map.put("Кашпирский", 550 );
        map.put("Инидиана", 400 );
        map.put("Рудуха", 100 );
        map.put("Будько", 600 );
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        final int buckses = 500;
        Iterator<Integer> iterator = map.values().iterator();
        while(iterator.hasNext()){
            if(iterator.next() < buckses){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
