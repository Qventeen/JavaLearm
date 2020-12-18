package level.level04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String str;
        if(n == 0) {
            System.out.println("ноль");
            return;
        }
        if(n < 0 )
            str = "отрицательное ";
        else
            str = "положительное ";

        if(n % 2 == 0)
            str += "четное число";
        else
            str += "нечетное число";

        System.out.println(str);
    }
}
