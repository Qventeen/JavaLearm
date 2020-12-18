package com.jr.level.level15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.intVar + " ");
        System.out.print(s.doubleVar + " ");
        System.out.print(s.DoubleVar + " ");
        System.out.print(s.booleanVar + " ");
        System.out.print(s.ObjectVar + " ");
        System.out.print(s.ExceptionVar + " ");
        System.out.print(s.StringVar);
    }
}
