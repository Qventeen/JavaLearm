package level.level07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int[] street = new int[15];
        boolean t = true;
        int chet = 0, nechet = 0;

        for(int i = 0; i < 15; i++){
            street[i] = Integer.parseInt(rd.readLine());
            if(t) {
                chet += street[i];
                t = !t;
            } else {
                nechet += street[i];
                t = !t;
            }
        }
        if(chet < nechet){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
