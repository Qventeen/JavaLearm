package level.level03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10, 25.1));
        System.out.println(convertEurToUsd(20, 25.2));
    }

    public static double convertEurToUsd(int eur, double course) {
        return eur*course;

    }
}
