package level.level07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human[] family = new Human[9];
        //Дедушки и бабушки
        family[0] = new Human("Захарий1", true, 55);
        family[1] = new Human("Галя1", false, 55);
        family[2] = new Human("Захарий2", true, 55);
        family[3] = new Human("Галя2", false, 55);
        //Отцы и матери
        family[4] = new Human("Владимир", true, 35, family[0], family[1]);
        family[5] = new Human("Людмила", false, 35, family[2], family[3]);
        //Детки
        family[6] = new Human("Васька", true,10, family[4], family[5]);
        family[7] = new Human("Машка", false,11, family[4], family[5]);
        family[8] = new Human("Танька", false,12, family[4], family[5]);

        for(Human h: family){
            System.out.println(h);
        }

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















