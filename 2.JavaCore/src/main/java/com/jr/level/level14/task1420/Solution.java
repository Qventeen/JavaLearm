package com.jr.level.level14.task1420;


import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(rd.readLine());
		int b = Integer.parseInt(rd.readLine());
		if(a <= 0 || b<= 0){
			throw new Exception();
		}

        System.out.println(nod(a, b));
    }


    public static int nod(int a, int b){
        //Алгоритм евклида
        while(a!=0 && b!=0){
            if(a < b){
                b %= a;
            } else {
                a %=b;
            }
        }
        return a+b;
    }
}
