package level.level05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    private String name = null;
    private int age = 0;
    private char sex = 0;

    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void initialize(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;

    }


    public static void main(String[] args) {

    }
}
