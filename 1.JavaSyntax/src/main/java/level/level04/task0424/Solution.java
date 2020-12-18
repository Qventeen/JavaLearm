package level.level04.task0424;

/* 
Три числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        int[] didgits = new int[3];
        final int count = 3;
        for (int i = 0; i < count; i++) {
            didgits[i] = Integer.parseInt(rd.readLine());
        }



        if(didgits[0] == didgits[1]){
            if(didgits[0] == didgits[2]){
                return;
            } else
                System.out.print(3);
        } else if(didgits[0] == didgits[2]){
            System.out.println(2);
        } else if(didgits[1] == didgits[2]){
            System.out.println(1);
        }
    }
}
