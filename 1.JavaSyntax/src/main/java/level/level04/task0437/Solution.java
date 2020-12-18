package level.level04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            for (int j = 9-i; j < 10 ; j++) {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
