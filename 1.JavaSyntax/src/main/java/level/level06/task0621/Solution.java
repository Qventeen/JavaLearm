package level.level06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Cat catGrandfather = new Cat(rd.readLine());

        Cat catGrandmother = new Cat(rd.readLine());

        Cat catFather = new Cat(rd.readLine(),null,catGrandfather);

        Cat catMother = new Cat(rd.readLine(),catGrandmother);

        Cat catSon = new Cat(rd.readLine(),catMother,catFather);

        Cat catDaughter = new Cat(rd.readLine(), catMother, catFather);

        System.out.println(catGrandfather);
        System.out.println(catGrandmother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMother;
        private Cat parentFather;

        Cat(String name, Cat mother, Cat father){
            this.name = name;
            parentMother = mother;
            parentFather = father;
        }
        Cat(String name) {
            this(name,null,null);
        }
        Cat(String name, Cat mother) {
            this(name,mother,null);
        }

        @Override
        public String toString() {
            String tmp = "Cat name is " + name;
            if (parentMother == null){
                tmp += ", no mother, ";
            } else {
                tmp += ", mother is " + parentMother.name + ",";
            }
            if(parentFather == null){
                tmp += " no father";
            } else{
                tmp += " father is " + parentFather.name;

            }
            return tmp;
        }
    }

}
