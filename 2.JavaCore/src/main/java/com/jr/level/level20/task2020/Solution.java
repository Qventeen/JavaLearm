package com.jr.level.level20.task2020;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        final transient String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        public Person(){
            this.greetingString = "Hello, ";
            this.fullName = String.format("%s %s", lastName, firstName);
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
           out.defaultWriteObject();
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();

        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}
