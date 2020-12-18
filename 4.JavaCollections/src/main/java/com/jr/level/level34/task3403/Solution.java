package com.jr.level.level34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        int i = 2;
        if(n < i){
            return;
        }
        while (n % i != 0) {
            i++;
        }
        System.out.println(i);
        recurse(n / i);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.recurse(132);
    }
}
