package com.jr.level.level12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        String name;
        if(o instanceof Tiger) name = "Тигр";
        else if(o instanceof Lion) name = "Лев";
        else if(o instanceof Cat) name = "Кот";
        else if(o instanceof Bull) name = "Бык";
        else if(o instanceof Cow) name = "Корова";
        else name = "Животное";

        return name;
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
