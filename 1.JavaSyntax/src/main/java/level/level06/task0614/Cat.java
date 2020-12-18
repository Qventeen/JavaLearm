package level.level06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat(){
        
    }

    public static void main(String[] args) {
        Cat[] cat = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cat[i] = new Cat();
            Cat.cats.add(cat[i]);
        }
        printCats();
    }

    public static void printCats() {
        for(Cat cat: Cat.cats)
            System.out.println(cat.toString());
    }
}
