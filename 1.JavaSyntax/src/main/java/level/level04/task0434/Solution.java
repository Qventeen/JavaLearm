package level.level04.task0434;


/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        final int ten = 10;
        int k, i;
        k = 1;

        while(k <= ten){
            i = 1;
            while (i <= ten) {
                System.out.print(k*i + " ");
                i++;
            }
            k++;
            System.out.println();
        }

    }
}
