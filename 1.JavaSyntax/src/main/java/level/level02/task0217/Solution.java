package level.level02.task0217;

/* 
Минимум четырех чисел
*/
public class Solution {
    public static int min(int a, int b, int c, int d) {
        int r1 = min(a, b);
        int r2 = min(c, d);
        
        return min(r1, r2);
    }

    public static int min(int a, int b) {
        if (b < a)
            a = b;
        
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-20, -10, -30, -40));
        System.out.println(min(-20, -10, -30, 40));
    }
}
