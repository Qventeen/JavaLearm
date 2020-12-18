package level.level04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        int[] n = new int[3];
        int rez = 0;
        for (int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(rd.readLine());
            if(n[i] > 0 ) {
                rez++;
            }
        }
        System.out.println(rez);

    }
}
