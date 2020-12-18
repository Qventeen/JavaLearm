package level.level03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int rez = 1;
        for (int k = 2; k <= 10; k++){
            rez *= k;
        }
        System.out.println(rez);
    }
}
