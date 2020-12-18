package com.jr.level.level14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    public static void println(Bridge br){
        if(br instanceof WaterBridge)
            System.out.println(((WaterBridge)br).getCarsCount());
        else
            System.out.println(((SuspensionBridge) br).getCarsCount());
    }
}

