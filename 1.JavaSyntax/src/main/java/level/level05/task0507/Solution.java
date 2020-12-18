package level.level05.task0507;

/* 
Среднее арифметическое
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        long sum = 0;
        int count = 0;
        int tmp;
        while(true){
            tmp = Integer.parseInt(rd.readLine());
            if(tmp == -1) {
                break;
            }
            sum += tmp;
            count++;
        }
        System.out.println((double)sum / count);
    }
}

