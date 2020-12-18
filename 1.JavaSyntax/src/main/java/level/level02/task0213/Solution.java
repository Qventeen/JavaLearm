package level.level02.task0213;

/* 
Питомцам нужны люди
*/
public class Solution {
    public static void main(String[] args) {
        Cat murzik = new Cat();
        Dog sharik = new Dog();
        Fish ribka = new Fish();
        Woman woman = new Woman();
        murzik.owner = woman;
        sharik.owner = woman;
        ribka.owner = woman;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
