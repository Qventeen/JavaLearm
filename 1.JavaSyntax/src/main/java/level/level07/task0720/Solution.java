package level.level07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> List = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n ; i++) {
            List.add(reader.readLine());
        }
        for (int i = 0; i < m; i++) {
            List.add(List.remove(0));
        }
        for(String s: List){
            System.out.println(s);
        }
    }
}
