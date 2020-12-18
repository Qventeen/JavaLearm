package level.level10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] arrayLists = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            arrayLists[i] = new ArrayList<String>();
            for (int j = 0; j < 5; j++) {
                arrayLists[i].add("Qventeen" + i + j);
            }
        }
        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
