package level.level07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> List = new ArrayList<>();
        List.add("мама");
        List.add("именно");
        List.add("мыла");
        List.add("именно");
        List.add("раму");
        List.add("именно");
        for (String s:
                List) {
            System.out.println(s);
        }
    }
}
