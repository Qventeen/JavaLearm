package level.level04.task0439;

/* 
Письмо счастья
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        final int ten = 10;
        for (int i = 0; i < ten; i++) {
            System.out.println(name + " любит меня.");
        }

    }
}
