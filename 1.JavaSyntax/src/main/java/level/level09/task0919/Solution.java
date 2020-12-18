package level.level09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divisionByZero();
        } catch (RuntimeException ex){
            ex.printStackTrace();
        }

    }

    public static void divisionByZero(){
        System.out.println( 1/0);
    }
}
