package level.level03.task0325;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       InputStream is = System.in;
       Reader rd = new InputStreamReader(is);
       BufferedReader reader = new BufferedReader(rd);
       String sn = reader.readLine();
       int n = Integer.parseInt(sn);
        System.out.println("Я буду зарабатывать $" + n + " в час");
    }
}
