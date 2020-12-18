package level.level08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        //List<String> addresses = new ArrayList<String>();
        Map<String, String> addresses = new HashMap<>();
        while (true) {

            String city = reader.readLine();
            if(city.isEmpty()) break;;

            String family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.put(city,family);
        }

        //read home number
        String inCity = reader.readLine();

        if (!inCity.isEmpty()) {
            System.out.println(addresses.get(inCity));
        }
    }
}
