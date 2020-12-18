package level.level09.task0926;

import java.util.ArrayList;
import java.util.Random;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> aList = new ArrayList<>();
        Random rand = new Random(47);
        int[] massleng = new int[] {5, 2, 4, 7, 0};
        for(Integer i: massleng){
            int[] tmp = new int[i];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = rand.nextInt(100);
            }
            aList.add(tmp);
        }
        return aList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
