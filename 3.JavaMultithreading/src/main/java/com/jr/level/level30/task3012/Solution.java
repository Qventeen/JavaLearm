package com.jr.level.level30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(3000);
        solution.createExpression(1);
        solution.createExpression(13111986);
    }


    public void createExpression(int number) {
        StringBuilder sb = new StringBuilder().append(number).append(" =");
        final int SYS = 3;
        int mod;
        int transBit = 0;
        int pow = 1;
        while (number > 0){
            mod = (number + transBit) % SYS;
            switch(mod){
                case 1: sb.append(" + ").append(pow);
                        transBit = 0;break;
                case 2: sb.append(" - ").append(pow);
                        transBit = 1;
            }
            pow *= SYS;
            number /= SYS;
        }
        if(transBit == 1) sb.append(" + ").append(pow);
        System.out.println(sb.toString());
    }


}
