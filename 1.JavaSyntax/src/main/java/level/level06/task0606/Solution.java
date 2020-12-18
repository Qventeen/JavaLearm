package level.level06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Reader rd = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(rd);
        int tmp = Integer.parseInt(r.readLine());
        tmp = tmp > 0? tmp: -tmp;
        while(tmp > 0 ) {
            if (tmp % 2 == 0)
                Solution.even++;
            else
                Solution.odd++;
            tmp/=10;    //Целочисленное деление на основание
        }
        System.out.print("Even: " + Solution.even + " Odd: " + Solution.odd );

    }
}
