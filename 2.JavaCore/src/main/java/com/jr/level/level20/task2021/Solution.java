package com.jr.level.level20.task2021;

import java.io.NotSerializableException;
import java.io.Serializable;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public SubSolution() throws NotSerializableException{
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
