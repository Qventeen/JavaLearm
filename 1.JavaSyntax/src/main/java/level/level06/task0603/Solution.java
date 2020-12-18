package level.level06.task0603;

/* 
По 50 000 объектов Cat и Dog
*/

public class Solution {
    public static void main(String[] args) {
        final int  count = 50000;
        Cat[] cats = new Cat[count];
        Dog[] dogs = new Dog[count];
        for (int i = 0; i < count; i++) {
            cats[i] = new Cat();
            dogs[i] = new Dog();
        }
    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
