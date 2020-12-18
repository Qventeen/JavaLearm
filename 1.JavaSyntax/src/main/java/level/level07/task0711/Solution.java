package level.level07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       ArrayList<String> listStr = new ArrayList<>();
       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            listStr.add(r.readLine());
        }
        for (int i = 0; i < 13; i++) {
            listStr.add(0,listStr.remove(4));
        }
        for (String s :
                listStr) {
            System.out.println(s);
        }
    }
}
