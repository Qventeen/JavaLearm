package level.level08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> ogorod = new HashMap<>();
        ogorod.put("арбуз","ягода");
        ogorod.put("банан","трава");
        ogorod.put("вишня","ягода");
        ogorod.put("груша","фрукт");
        ogorod.put("дыня","овощ");
        ogorod.put("ежевика","куст");
        ogorod.put("жень-шень","корень");
        ogorod.put("земляника","ягода");
        ogorod.put("ирис","цветок");
        ogorod.put("картофель","клубень");

        Iterator<Map.Entry<String, String>> iterator = ogorod.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
