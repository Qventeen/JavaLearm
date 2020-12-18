package com.jr.level.level35.sandbox;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTypeWithReflection {
    interface Num<T>{}

    public static void main(String[] args) {
        //Test 1
        System.out.println(getNameOfGenericType(25));
        //Test 2
        List<Integer> integers = new ArrayList<>();
        integers.add(25);
        System.out.println(getNameOfGenericType(integers));
        //Test3
        System.out.println(getTypeOfParamFromClass(integers));
        //Test4
        System.out.println(getTypeOfParamFromClass(new ArrayList<Integer>(){}));
        //Test5
        System.out.println("=============================");
        getTypeParamFromInterface(new Num<Integer>(){});

    }

    public static <T> String getNameOfGenericType(T element){
        return element.getClass().getSimpleName();
    }

    public static <T> String getTypeOfParamFromClass(List<T> elements){
        Class<?> clazz = elements.getClass();

        ParameterizedType paramType = (ParameterizedType) clazz.getGenericSuperclass();
        String nameParamType = paramType.getTypeName();
        Type rawType = paramType.getRawType();

        System.out.printf("nameParamType = %s%n", nameParamType);
        System.out.printf("rawType = %s%n", rawType.getTypeName());

        System.out.println("Type parameters:");
        for(Type type: paramType.getActualTypeArguments()){
            System.out.printf("\t\t paramType = %s %n", type);
        }


        return paramType.getActualTypeArguments()[0].getTypeName();



    }

    public static <T> void getTypeParamFromInterface(Num<T> elements){
        Type[] types = elements.getClass().getGenericInterfaces();
        //ParameterizedType[] paramTypes = (ParameterizedType[]) types;
        for(Type t: types) {
            if (t instanceof ParameterizedType) {
                System.out.println(Arrays.toString(((ParameterizedType) t).getActualTypeArguments()));

            } else
                System.out.println(t.getTypeName());
        }
    }

}
