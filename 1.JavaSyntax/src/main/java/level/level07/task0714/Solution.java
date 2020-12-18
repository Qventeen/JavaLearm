package level.level07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new  BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            if(!strings.add(r.readLine()))  {
                System.out.println("Некорректный ввод.");
                break;
            }
        }
        strings.remove(2);
        int k = 4;
        while(k >0){
            System.out.println(strings.get(--k));
        }
    }
}


