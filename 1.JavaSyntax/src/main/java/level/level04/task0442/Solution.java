package level.level04.task0442;


/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        final int exit = -1;
        int sum = 0;
        int tmp;
        while(true){
            tmp = Integer.parseInt(rd.readLine());
            sum += tmp;
            if(tmp == exit) {
                System.out.println(sum);
                return;
            }

        }
    }
}
