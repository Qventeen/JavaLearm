package level.level10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char [] array = s.toCharArray();
        for (int i = 0; i < 40; i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.print(array[j]);
            }
            System.out.println();
        }
    }

}

