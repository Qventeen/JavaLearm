package level.level01.task0130;

/* 
Наш первый конвертер!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(41));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
        //TC = (TF – 32) * 5/9
        /*
            (TF-32)*5/9 = TC
            (TF-32)*5 = TC*9
            TF-32 = TC*9/5
            TF= = TC*9/5+32
        */
        return celsium * 9.0/5.0 + 32;
    }
}
