package level.level05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat("vaska",2,1, 3);
        Cat cat2 = new Cat("muska",3,4, 7);
        Cat cat3 = new Cat("murka",5,3, 5);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
