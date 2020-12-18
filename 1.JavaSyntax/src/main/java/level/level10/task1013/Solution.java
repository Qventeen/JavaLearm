package level.level10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String lastname = "nolastname";
        private boolean sex = true;
        private int age = 0;
        private String country = "nocountry";
        private String addres = "noadress";



        public Human(String name){
            this.name = name;
        }
        public Human(String name, String lastname){
            this(name);
            this.lastname = lastname;
        }
        public Human(String name,String lastname, boolean sex){
            this(name,lastname);
            this.sex = sex;
        }
        public Human(String name, String lastname, boolean sex, int age){
            this(name,lastname,sex);
            this.age = age;
        }
        public Human(String name, String lastname, boolean sex, int age, String country){
            this(name,lastname,sex,age);
            this.country = country;
        }
        public Human(String name, String lastname, boolean sex, int age, String country, String addres){
            this(name,lastname,sex,age,country);
            this.addres = addres;
        }
        public Human(Human human){
            this.name = human.name;
            this.lastname = human.lastname;
            this.sex = human.sex;
            this.addres = human.addres;
            this.age = human.age;
            this.country = human.country;
        }
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Human(String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, String lastname, String addres){
            this(name,lastname);
            this.addres = addres;
        }

    }
}
