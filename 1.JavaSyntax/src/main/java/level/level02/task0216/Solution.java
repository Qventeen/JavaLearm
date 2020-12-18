package level.level02.task0216;

/* 
Минимум трёх чисел
*/
public class Solution {
    public static int min(int a, int b, int c) {
        int d;
        if (a < b)
            d = a;
        else
            d = b;
            
        if (c < d)
            d = c;
        
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(10, 5, 10));
    }

}
