package level.level05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());
        for (int i = 1, tmp; i < N ; i++) {
            tmp = Integer.parseInt(reader.readLine());
            if(tmp > maximum)
                maximum = tmp;
        }

        System.out.println(maximum);
    }
}
