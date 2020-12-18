package level.level04.task0417;

/* 
Существует ли пара?
*/
/*
    фиговое получилось решение
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] vvod = new int[3];
        Reader rd = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(rd);
        for (int i = 0; i < 3; i++) {
            vvod[i] = Integer.parseInt(reader.readLine());
        }
        if(vvod[0] == vvod[1]){
            System.out.print(vvod[0] + " " + vvod[1]);
            if(vvod[0] == vvod[2])
                System.out.print(" " + vvod[2]);
            return;
        }
        if(vvod[0] == vvod[2]) {
            System.out.print(vvod[0] + " " + vvod[2]);
            return;
        }
        if(vvod[1] == vvod[2])
            System.out.print(vvod[1] + " " + vvod[2]);
    }
 }


/* Дано три целых числа А В С
   Какие есть варианты
    Если есть пара то может быть три
    Если нет пары то может быть другая пара
*/
