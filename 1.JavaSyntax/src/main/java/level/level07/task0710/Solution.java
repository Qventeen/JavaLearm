package level.level07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        final int ten = 10;
        for(int i = 0; i < ten; i++){
            strings.add(0,r.readLine());
        }
        for(String str: strings){
            System.out.println(str);
        }

    }
}
