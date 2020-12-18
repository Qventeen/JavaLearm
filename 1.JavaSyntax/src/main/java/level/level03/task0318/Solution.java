package level.level03.task0318;

/* 
План по захвату мира
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sAge = reader.readLine();
        int Age = Integer.parseInt(sAge);
        String name = reader.readLine();
        System.out.println(name + " захватит мир через " + Age + " лет. Му-ха-ха!");
    }
}
