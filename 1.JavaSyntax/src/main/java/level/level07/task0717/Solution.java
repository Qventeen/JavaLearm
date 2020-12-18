package level.level07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int ten = 10;
        for (int i = 0; i < ten; i++) {
            list.add(reader.readLine());
        }


        ArrayList<String> result = doubleValues(list);
        for(String str: result){
            System.out.println(str);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        int i = 0;
        int k = list.size();
        while(i < list.size()){
            list.add(i, list.get(i));
            i += 2;
        }
        //для тренировки возвращаю копию.
        return list;
    }
}
