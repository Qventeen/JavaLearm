package level.level05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Sergey", 31, "Kyev");
        Man man2 = new Man("Vasya", 43, "Roslavichi");
        Woman woman1 = new Woman("Raya", 45, "Kyev");
        Woman woman2 = new Woman("Dasha", 27, "Roslavichi");
        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
    }

    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public String toString(){
            return name + " " + age + " " + address;
        }
    }
}
