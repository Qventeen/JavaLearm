package com.jr.level.level36.sandbox.utils;

import java.lang.reflect.Field;

public class ReflectUtils {
    public static <T, R> R getPrivateField(Class<?> srcClass, T source, String fieldName){
        R result = null;
        try {
            Field field = srcClass.getDeclaredField(fieldName);

            field.setAccessible(true);
            result = (R) field.get(source);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> void printFields(Class<?> clazz, T source){
        Field[] fields = clazz.getDeclaredFields();
        try{
            for(Field field: fields){
                field.setAccessible(true);
                System.out.printf("%s = %s%n",
                        field.getName(),
                        field.get(source)
                );
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
