package level.level07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(list.get(i)).append(" ").append(list.get(i));
            if(list.get(i).length() % 2 != 0){
                buffer.append(" ").append(list.get(i));
            }
            newList.add(buffer.toString());
        }
        for(String s: newList)
            System.out.println(s);



//        ArrayList<String> listUpperCase = new ArrayList<String>();
//        for (int i = 0; i < list.size(); i++) {
//            String s = list.get(i);
//            listUpperCase.add(s.toUpperCase());
//        }
//
//        for (int i = 0; i < listUpperCase.size(); i++) {
//            System.out.println(listUpperCase.get(i));
//        }
    }
}
