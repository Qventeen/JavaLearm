package com.jr.level.level39.task3912;

import static java.lang.Math.*;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 },
                { 1, 0, 1, 1, 0, 1, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1 }
        };
        printMatrix(matrix);
        System.out.println(maxSquare(matrix));
        printMatrix(matrix);
    }

    public static int maxSquare(int[][] matrix) {
        int maxEdge = 0;
        for(int y = 1; y < matrix.length; y++){
            for(int x = 1; x < matrix[y].length; x++){
                if(matrix[y][x] != 0){
                    matrix[y][x] = min(min(matrix[y-1][x], matrix[y][x -1]), matrix[y-1][x-1]) + 1;
                    maxEdge = max(matrix[y][x], maxEdge);
                }
            }
        }
        return maxEdge * maxEdge;
    }

    public static void printMatrix(int[][] matrix){
        for(int[] y: matrix){
            for (int x: y){
                System.out.printf("%d ", x );
            }
            System.out.println();
        }
    }
}

