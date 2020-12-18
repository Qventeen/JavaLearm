package level.level04.task0423;

/* 
Фейс-контроль
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws Exception {
        final int lock = 20;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        int age = Integer.parseInt(rd.readLine());

        if(age > lock)
            System.out.println("И 18-ти достаточно");
    }
}
