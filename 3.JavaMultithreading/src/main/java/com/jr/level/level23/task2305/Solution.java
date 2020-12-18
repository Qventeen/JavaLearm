package com.jr.level.level23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        // Метод не имеет ссылки на объект
        // Создать массив sol
        Solution [] sol = new Solution[2];
        // Для каждого элемента массива
        for(int i = 0; i < sol.length; i++){
            // Создать объект sol
            sol[i] = new Solution();
            // Для каждой переменной массива внутреннего класса
            // создать элемент встроенного класса
            for(int k = 0; k < sol[i].innerClasses.length; k++){
                sol[i].innerClasses[k] = sol[i].new InnerClass();
            }
        }
        return sol;
    }

    public static void main(String[] args) {

    }
}
