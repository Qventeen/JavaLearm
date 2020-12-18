package com.jr.level.level35.sandbox;

import java.util.List;

public class WildcardCapture {

    public static void captureWithoutHelper(List<?> list){
        //list.set(0,list.get(0));
    }

    public static void captureWithHelper(List<?> list){
        helper(list);
    }

    public static void captureForUpperBoundedWildcard(List<? extends Number> list){
        helper(list);
    }

    private static <T> void helper(List<T> list){
        list.set(0,list.get(0));
    }
}
