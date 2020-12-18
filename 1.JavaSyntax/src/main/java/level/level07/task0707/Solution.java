package level.level07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("Привет мир!");
        strArr.add("Меня зовут Серега.");
        strArr.add("Мне 31 год.");
        strArr.add("Я программист.");
        strArr.add("Я планирую в течении этого года устроится на работу разработчиком.");

        System.out.println(strArr.size());
        for(String s: strArr){
            System.out.println(s);
        }
    }
}
