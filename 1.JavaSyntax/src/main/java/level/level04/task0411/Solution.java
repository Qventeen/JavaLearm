package level.level04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        String s;
        int k = (month / 3 + 1) % 4;
        switch (k){
            case 1: s = "зима"; break;
            case 2: s = "весна"; break;
            case 3: s = "лето"; break;
            case 0: s = "осень"; break;
            default: s = "Некорректное значение";
        }
        System.out.println(s);
    }
}
