package level.level04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    	String s = rd.readLine();
    	int n = Integer.parseInt(rd.readLine());
    	int k = 0;
    	while(n-- > k)
			System.out.println(s);
	}
}
