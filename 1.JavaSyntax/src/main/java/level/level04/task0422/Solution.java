package level.level04.task0422;

/* 
18+
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        int a = Integer.parseInt(rd.readLine());
        if(a < 18){
            System.out.println("Подрасти еще");
        }
    }

    /*public static int buffered(String n) throws IOException{
        Reader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        n.concat(rd.readLine());
        n.length();
        int age = Integer.parseInt(rd.readLine());
        return age;
    }*/


}

