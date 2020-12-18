package level.level07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int[] items = new int[20];
        int[] smal1 = new int[10];
        int[] smal2 = new int[10];
        for (int i = 0; i < 20; i++) {
            items[i] = Integer.parseInt(rd.readLine());
        }
        for (int i = 0; i < 10; i++) {
            smal1[i] = items[i];
        }
        for (int i = 10, j=0; i < 20; i++, j++) {
            smal2[j] = items[i];
        }
        for (int i :
                smal2) {
            System.out.println(i);
        }
    }
}
