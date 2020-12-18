package com.jr.level.level12.task1227;

/* 
Fly, Run, Swim для классов Duck, Penguin, Toad
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }

    public class Duck implements Swim, Run, Fly {
        @Override
        public void swim(){}
        @Override
        public void run(){}
        @Override
        public void fly(){}
    }

    public class Penguin implements Swim, Run {
        @Override
        public void swim(){}
        @Override
        public void run(){}
    }

    public class Toad implements Swim{
        @Override
        public void swim(){}

    }
}
