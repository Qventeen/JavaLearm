package com.jr.level.level20.task2018;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Найти ошибки
*/
public class Solution implements Serializable {
    public static class A {

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }
        public A(){}
    }

    public class B extends A implements Serializable {
        private String nameB;
        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }
        private void writeObject(ObjectOutputStream outputStream) throws IOException{
            outputStream.defaultWriteObject();
            outputStream.writeObject(nameA);
            //outputStream.writeObject(nameB);
        }
        private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException{
            inputStream.defaultReadObject();
            nameA = (String) inputStream.readObject();
            //nameB = (String) inputStream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);
        FileOutputStream tfout = new FileOutputStream(args[0]);
        tfout.write(arrayOutputStream.toByteArray());


        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
