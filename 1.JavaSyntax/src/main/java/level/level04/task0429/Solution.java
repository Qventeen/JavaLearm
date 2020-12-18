package level.level04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int plus = 0;
        int minus = 0;
        for (int i = 0; i < 3; i++) {
            int n;
            n = Integer.parseInt(rd.readLine());
            if( n > 0 )
                plus++;
            else if(n < 0)
                minus++;
        }
        System.out.println("количество отрицательных чисел: " + minus );
        System.out.println("количество положительных чисел: " + plus );
    }
}
