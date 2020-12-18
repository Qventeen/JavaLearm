package level.level08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        //Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);

        String in = rd.readLine();

        System.out.println(in + " is " + map.get(in) + " month");



//        List<String> mounth = new ArrayList<>(set);
//        for (int i = 0; i < mounth.size(); i++) {
//            if(mounth.get(i).equals(in)){
//                System.out.println(in + " is " + (i+1) + " month");
//                return;
//            }
//        }
    }
}
