package level.level07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/*
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        int[] tmp = new int[20];
        for(int i = 0; i < 20; i++){
            tmp[i] = Integer.parseInt(rd.readLine());
        }
        return tmp;
    }

    public static int max(int[] array) {
        int tmp = array[0];
        for(int tmp2: array){
            if(tmp2 > tmp) tmp = tmp2;
        }
        return tmp;
    }
}
