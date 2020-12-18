package level.level06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sortmas = new int[5];
        for (int i = 0; i < 5; i++) {
            sortmas[i] = Integer.parseInt(reader.readLine());
        }
        sortmas = sort(sortmas);
        for(int i: sortmas){
            System.out.println(i);
        }

    }
    public static int[] sort(int[] s){
        int tmp;
        for (int i = 0; i < 4; i++) {
            for(int j = i+1; j < 5; j++){
                if(s[i] > s[j]){
                    tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                }
            }
        }
        return s;
    }
}
