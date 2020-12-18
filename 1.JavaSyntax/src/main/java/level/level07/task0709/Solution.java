package level.level07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String tmp;
        strings.add(r.readLine());
        tmp = strings.get(0);
        int indexMin = 0;
        for (int i = 1; i < 5; i++) {
            strings.add(r.readLine());
            if(strings.get(i).length() < tmp.length()){
                tmp = strings.get(i); //присваивание ссылки думаю не лучшая идея но тут вероятно сойдет
                indexMin = i;
            }
        }
        System.out.println(tmp);
        for (int i = 0; i < 5; i++) {
            if(i != indexMin && tmp.length() == strings.get(i).length())
                System.out.println(strings.get(i));
        }
    }}
