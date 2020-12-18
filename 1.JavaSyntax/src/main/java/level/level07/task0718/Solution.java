package level.level07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        final int ten = 10;
        for (int i = 0; i < ten; i++) {
            list.add(rd.readLine());
        }
        for (int j = 0; j < list.size()-1; j++) {

            if (list.get(j).length() >= list.get(j+1).length()) {
                System.out.println(j+1);
                break;
            }
        }
    }
}

