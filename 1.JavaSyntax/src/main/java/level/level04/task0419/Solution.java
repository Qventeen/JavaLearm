package level.level04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader rd = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(rd);
        int[] vvod = new int[4];
        for (int i = 0; i < 4; i++) {
            vvod[i] = Integer.parseInt(reader.readLine());
        }
        int rez = vvod[0];
        for (int i = 1; i < 4; i++) {
            if(rez < vvod[i]) rez = vvod[i];
        }
        System.out.print(rez);
    }
}
