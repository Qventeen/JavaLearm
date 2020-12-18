package com.jr.level.level38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object string = "hello";
        Integer integer = (Integer) string;
    }

    public void methodThrowsNullPointerException() {
        String str = null;
        str.trim();
    }

    public static void main(String[] args) {
        VeryComplexClass vcc = new VeryComplexClass();
//        vcc.methodThrowsNullPointerException();
        vcc.methodThrowsClassCastException();
    }
}
