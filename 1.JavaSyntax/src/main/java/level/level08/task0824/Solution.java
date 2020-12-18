package level.level08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        List<Human> fem = new ArrayList<Human>();
        for (int i = 0; i < 9; i++) {
            fem.add(new Human());
        }
        fem.get(0).children.add(fem.get(4));
        fem.get(1).children.add(fem.get(4));
        fem.get(2).children.add(fem.get(5));
        fem.get(3).children.add(fem.get(5));
        fem.get(4).children.add(fem.get(6));
        fem.get(4).children.add(fem.get(7));
        fem.get(4).children.add(fem.get(8));
        fem.get(5).children.add(fem.get(6));
        fem.get(5).children.add(fem.get(7));
        fem.get(5).children.add(fem.get(8));

        for(Human h:fem){
            System.out.println(h);
        }
    }

    public static class Human {
        String name = "name";
        boolean sex;
        int age = 20;
        ArrayList<Human> children = new ArrayList<>();


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
