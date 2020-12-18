package level.level04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader rd = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(rd);

        int n = Integer.parseInt(r.readLine());
        if (n < 1 || n >= 1000)
            return;

        String str;
        if (n % 2 == 0)
            str = "четное ";
        else
            str = "нечетное ";

        if (n / 100 > 0) {
            str += "трехзначное ";
        } else if (n / 10 > 0)
            str += "двузначное ";
        else
            str += "однозначное ";

                str += "число";
        System.out.println(str);
    }
}
