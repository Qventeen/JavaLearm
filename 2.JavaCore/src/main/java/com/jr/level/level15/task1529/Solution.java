package com.jr.level.level15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static Flyable result;
    static {
        reset();
    }



    public static void reset() {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            String arg = rd.readLine();
            rd.close();
            if("plane".equals(arg)){
				result = new Plane(500);
			} else if("helicopter".equals(arg)){
				result = new Helicopter();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
