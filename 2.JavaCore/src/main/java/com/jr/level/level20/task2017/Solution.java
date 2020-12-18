package com.jr.level.level20.task2017;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A a = null;
        try {
            Object o = objectStream.readObject();
            if(!(o instanceof A)){
                throw new ClassCastException();
            }
            a = (A) o;
        } catch (Exception e){
            return null;
        }
        return a;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
