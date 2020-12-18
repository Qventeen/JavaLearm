package com.jr.level.level36.task3602;

import java.util.Arrays;
import java.util.Collections;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        return Arrays
                .stream(classes)
                .filter(e -> "EmptyList".equals(e.getSimpleName()))
                .findAny()
                .get();
    }
}
