package level.level07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        String[] str = new String[10];
        for (int i = 0; i < 8; i++) {
            str[i] = rd.readLine();
        }
        int i = 10;
        while(0 < i) {
            System.out.println(str[--i]);
        }
    }
}
