package level.level07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> List = new ArrayList<>();
        String tmpstr;
        while(true){
            tmpstr = reader.readLine();
            if( "end".equals(tmpstr) == true ){
                break;
            }
            List.add(tmpstr);
        }
        for(String str: List){
            System.out.println(str);
        }
    }
}
