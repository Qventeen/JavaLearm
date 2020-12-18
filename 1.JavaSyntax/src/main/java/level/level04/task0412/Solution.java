package level.level04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader rd = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(rd);
        String sN = reader.readLine();
        int N = Integer.parseInt(sN);

        if (N < 0) N++;
        else if (N > 0) N*=2;

        System.out.println(N);

    }

}
