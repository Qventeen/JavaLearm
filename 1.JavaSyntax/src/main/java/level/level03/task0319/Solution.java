package level.level03.task0319;

/* 
Предсказание на будущее
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sCash = reader.readLine();
        String sAge = reader.readLine();
        int nCash = Integer.parseInt(sCash);
        int nAge = Integer.parseInt(sAge);
        System.out.println(name + " получает " + nCash + " через " + nAge +  " лет.");

    }
}
