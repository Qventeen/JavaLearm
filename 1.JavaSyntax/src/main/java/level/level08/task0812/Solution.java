package level.level08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> aList = new ArrayList<>();
        int     tcount = 1,
                max = 1;
        aList.add(Integer.parseInt(rd.readLine()));
        for(int i = 1; i < 10; i++){
                aList.add(Integer.parseInt(rd.readLine()));
                if(aList.get(i-1) == aList.get(i)) {
                    tcount++;
                    max = (tcount > max) ? tcount : max;
                }
                else
                    tcount = 1;
        }
        System.out.println(max);
    }
}
