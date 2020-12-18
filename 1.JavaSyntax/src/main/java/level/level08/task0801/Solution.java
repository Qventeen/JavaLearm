package level.level08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> hs = new HashSet<>();
        hs.add("арбуз");
        hs.add("банан");
        hs.add("вишня");
        hs.add("груша");
        hs.add("дыня");
        hs.add("ежевика");
        hs.add("жень-шень");
        hs.add("земляника");
        hs.add("ирис");
        hs.add("картофель");

        Iterator<String> iterator = hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }
}
