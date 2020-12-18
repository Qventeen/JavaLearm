package level.level04.task0418;

/* 
Минимум двух чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a = a < b ? a:b;
        System.out.println(a);
    }
}
