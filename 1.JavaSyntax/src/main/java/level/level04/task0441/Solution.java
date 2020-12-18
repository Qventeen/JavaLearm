package level.level04.task0441;


/* 
Как-то средненько
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        final int thry = 3;
        int[] n = new int[thry];
        int avar = 0;
        for (int i = 0; i < thry; i++) {
            n[i] = Integer.parseInt(rd.readLine());
            avar += n[i];
        }

        avar = Math.round((float) avar / n.length);
        int index = 0;
        int zooming = abs(n[0] - avar);
        int tmp;
        for (int i = 1; i < thry; i++) {
            tmp = abs(n[i] - avar);
            if (zooming > tmp) {
                zooming = tmp;
                index = i;
            }
        }
        System.out.println(n[index]);

    }
    public static int abs(int a){
        return a<0? -a:a;
    }



}


