package level.level04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
       Reader rd = new InputStreamReader(System.in);
       BufferedReader reader = new BufferedReader(rd);
       final String     green = "зеленый",
                        red = "красный",
                        yellow = "желтый";

        double t = Double.parseDouble(reader.readLine());
        int k1 = 3, k2 = 4;
        t %= 5;
        if(t < k1)      System.out.println(green);
        else if(t < k2) System.out.println(yellow);
        else            System.out.println(red);
    }
}
