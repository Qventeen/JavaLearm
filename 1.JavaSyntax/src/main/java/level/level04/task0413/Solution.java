package level.level04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader rd = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(rd);
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        switch (n){
            case 1: str = "понедельник"; break;
            case 2: str = "вторник"; break;
            case 3: str = "среда"; break;
            case 4: str = "четверг"; break;
            case 5: str = "пятница"; break;
            case 6: str = "суббота"; break;
            case 7: str = "воскресенье"; break;
            default: str = "такого дня недели не существует";
        }
        System.out.println(str);
    }
}
