package level.level07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(r.readLine());
        }
        int max, min, nmax, nmin;
        max = min = strings.get(0).length();
        nmax = nmin = 0;

        for (int i = 1; i < 10; i++) {
            if(strings.get(i).length() < min){
                min = strings.get(i).length();
                nmin = i;
            }
            else if(strings.get(i).length() > max){
                max = strings.get(i).length();
                nmax = i;
            }
        }
        if (nmax < nmin){
            System.out.println(strings.get(nmax));
        } else
            System.out.println(strings.get(nmin));
    }
}
