package com.jr.level.level12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        String nameclass;
        if(o instanceof Cat) nameclass = "Кот";
        else if(o instanceof Tiger) nameclass = "Тигр";
        else if(o instanceof Lion) nameclass = "Лев";
        else if(o instanceof Bull) nameclass = "Бык";
        else nameclass = "хз";

        return nameclass;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
