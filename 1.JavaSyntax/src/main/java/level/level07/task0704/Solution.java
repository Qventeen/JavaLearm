package level.level07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
       int[] items = new int[10];
        for (int i = 0; i < 10; i++) {
            items[i] = Integer.parseInt(rd.readLine());
        }

       int tmp;
       for(int a = 0, b = 9; a < b; a++, b--) {
           tmp = items[a];
           items[a] = items[b];
           items[b] = tmp;
       }
        for (int i :
                items) {
            System.out.println(i);
        }

    }
}

