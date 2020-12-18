package level.level07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mass = new int[20];
        int maximum;
        int minimum;
        maximum = minimum = mass[0] = Integer.parseInt(reader.readLine());
        for (int i = 1; i < 20; i++) {
            mass[i] = Integer.parseInt(reader.readLine());
            if (maximum < mass[i]) maximum = mass[i];
            else if (minimum > mass[i]) minimum = mass[i];
        }
        System.out.print(maximum + " ");
        System.out.print(minimum);
    }
}
