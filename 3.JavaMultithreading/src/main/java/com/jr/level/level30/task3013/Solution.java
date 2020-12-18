package com.jr.level.level30.task3013;

/* 
Набираем код
*/


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);

    }


    public int resetLowerBits(int number) {
                                    //00001bbbbbbbbbbbbbbbbbbbbbbbbbbb|
        number |= number >> 1;      //000011bbbbbbbbbbbbbbbbbbbbbbbbbb|
        number |= number >> 2;      //00001111bbbbbbbbbbbbbbbbbbbbbbbb|
        number |= number >> 4;      //000011111111bbbbbbbbbbbbbbbbbbbb|
        number |= number >> 8;      //00001111111111111111bbbbbbbbbbbb|
        number |= number >> 16;     //00001111111111111111111111111111|
        number &= ~ (number >> 1);  //00000111111111111111111111111111|
                                    //11111000000000000000000000000000|
                                    //00001000000000000000000000000000|;

        return number;
    }
}
