package level.level04.task0425;

/* 
Цель установлена!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int OX = scan(sc);
        int OY = scan(sc);
        System.out.println(chvert(OX, OY));

    }

    public static int scan(Scanner s) throws IOException {
        int tmp = s.nextInt();
        return tmp;
    }
    public static int chvert(int x, int y){
        int n;
        if(x > 0) {
            if (y > 0)
                n = 1;
            else
                n = 4;
        } else if(y > 0)
            n = 2;
        else
            n = 3;
        return n;
    }

}
