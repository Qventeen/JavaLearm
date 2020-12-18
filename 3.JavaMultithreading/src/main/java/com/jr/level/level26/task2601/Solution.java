package com.jr.level.level26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] test = {13,11,20,5,4,9,3,45};
//        test = sort(test);
//        for(Integer i: test){
//            System.out.println(i);
//        }
//        System.out.println("Test2");
//        Integer[] test2 = {9, 0, -2, -9, -4, 20, 5};
//        test2 = sort(test2);
//        for(Integer i: test2){
//            System.out.println(i);
//        }
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array, Comparator.naturalOrder());
        double median;
        int medianIndex;
        if (array.length % 2 == 0) {
            medianIndex = array.length / 2 - 1;
            median = (array[medianIndex] + array[medianIndex + 1]) / 2;
        } else {
            medianIndex = array.length / 2;
            median = array[medianIndex];
        }


        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(Math.abs(median - o1), Math.abs(median - o2));
            }
        });
        return array;
    }

}
