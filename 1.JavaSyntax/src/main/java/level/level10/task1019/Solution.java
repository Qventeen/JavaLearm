package level.level10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int id;
		String name;
		try {
			while (true) {
				id = Integer.parseInt(reader.readLine());
				name = reader.readLine();
				if (!name.isEmpty()) {
					map.put(name, id);
				} else {
					break;
				}
			}
		}catch(NumberFormatException e){

		}


		for (Map.Entry<String, Integer> pair : map.entrySet())
			System.out.println(pair.getValue() + " " + pair.getKey());
	}
}
