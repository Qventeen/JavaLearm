package level.level04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if(a+b <= c || a+c <= b || b+c <= a)
            System.out.println("Треугольник не существует.");
        else
            System.out.println("Треугольник существует.");
    }
}
