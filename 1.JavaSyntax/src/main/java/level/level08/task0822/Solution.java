package level.level08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = Integer.MAX_VALUE;
        //обход коллекции используя встроенный итератор
        for(int n :array){
            if(min > n) min = n;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(rd.readLine()));
        }
        return list;
    }
}
