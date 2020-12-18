package level.level08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //насколько я помню строка является неизменяемым объектом
        String s = reader.readLine();
        char[] chars = s.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if(chars[i-1] == ' '){
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        System.out.println(chars);
    }
}
