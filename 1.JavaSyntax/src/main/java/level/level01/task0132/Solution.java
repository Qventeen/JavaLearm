package level.level01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int rez = 0;
        while (number > 0) {
            rez += number % 10;
            number /=10;
        }
        return rez;
    }
}
