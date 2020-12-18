package level.level07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> List = new ArrayList<>();
        ArrayList<Integer> LThree = new ArrayList<>();
        ArrayList<Integer> LTwo = new ArrayList<>();
        ArrayList<Integer> LOther = new ArrayList<>();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        final int twenty = 20;
        final int three = 3;
        final int two = 2;
        for (int i = 0; i < twenty ; i++) {
            if(!List.add(Integer.parseInt(r.readLine()))){
                System.out.println("Некорректный ввод.");
                break;
            }
        }
        for(int i: List){  //автораспаковка в int
            if(i % two != 0 && i % three != 0)
                LOther.add(i);
            else {
                if (i % three == 0) {
                    LThree.add(i);
                }
                if (i % two == 0) {
                    LTwo.add(i);
                }
            }
        }
        printList(LTwo);
        printList(LThree);
        printList(LOther);
    }
    public static void printList(List<Integer> list) {
        for(int i: list){
            System.out.println(i);
        }
    }
}
