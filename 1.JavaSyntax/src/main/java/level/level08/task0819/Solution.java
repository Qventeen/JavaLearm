package level.level08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Cat tmp = cats.iterator().next();
        cats.remove(tmp);
        printCats(cats);
    }
    //step 2
    public static Set<Cat> createCats() {
        Set<Cat> setCat = new HashSet<Cat>();
        setCat.add(new Cat());
        setCat.add(new Cat());
        setCat.add(new Cat());
        return setCat;
    }
    // step 4 - пункт 4
    public static void printCats(Set<Cat> cats) {
        for(Cat c:cats){
            System.out.println(c.toString());
        }

    }
    // step 1
    public static class Cat{
        public Cat(){
        }
//        private String name;
//        public Cat(String name){
//            this.name = name;
//        }
//        @Override
//        public String toString(){
//            return name;
//        }
    }
}
