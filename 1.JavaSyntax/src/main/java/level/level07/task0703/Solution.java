package level.level07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));


        String[] str = new String[10];
        int[] n = new int[10];

        for (int i = 0; i < 10; i++){
            str[i] = rd.readLine();
            n[i] = str[i].length();
        }
        for(int i: n){
            System.out.println(i);
        }
    }
}
