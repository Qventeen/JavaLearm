package level.level04.task0421;

/* 
Настя или Настя?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] names = vvod();
        if(names[0].equals(names[1]))
            System.out.println("Имена идентичны");
        else if(names[0].length() == names[1].length())
            System.out.println("Длины имен равны");
    }
    public static String[] vvod() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[2];
        for (int i = 0; i < 2; i++) {
            str[i] = rd.readLine();
        }
        return str;
    }
}
