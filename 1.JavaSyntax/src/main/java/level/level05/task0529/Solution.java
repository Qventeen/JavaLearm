package level.level05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String str = rd.readLine();
        int sum = 0;
        while(!("сумма".equals(str))){
            sum += Integer.parseInt(str);
            str = rd.readLine();
        }
        System.out.println(sum);
    }
}
