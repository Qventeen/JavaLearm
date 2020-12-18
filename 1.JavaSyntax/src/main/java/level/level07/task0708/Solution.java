package level.level07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String tmp;
        strings.add(r.readLine());
        tmp = strings.get(0);
        int indexMax = 0;
        for (int i = 1; i < 5; i++) {
            strings.add(r.readLine());
            if(strings.get(i).length() > tmp.length()){
                tmp = strings.get(i); //присваивание ссылки думаю не лучшая идея но тут вероятно сойдет
                indexMax = i;
            }
        }
        System.out.println(tmp);
        for (int i = 0; i < 5; i++) {
            if(i != indexMax && tmp.length() == strings.get(i).length())
                System.out.println(strings.get(i));
        }
    }
}
