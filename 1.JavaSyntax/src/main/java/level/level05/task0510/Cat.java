package level.level05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private String name, address, color;
    private int age, weight;

    public void initialize(String name){
        //кроме адреса
        this.name = name;
        age = 3;
        weight = 2;
        color = "Черный";
    }
    public void initialize(String name, int weight, int age){
        //кроме адреса
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "Черный";
    }
    public void initialize(String name, int age){
        //кроме адреса
        this.name = name;
        this.age = age;
        weight = 2;
        color = "Черный";
    }
    public void initialize(int weight, String color ){
        //кроме адреса и цвета
        this.weight = weight;
        this.color = color;
        age = 3;
    }
    public void initialize(int weight, String color, String address){
        //кроме имени
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 3;
    }



    public static void main(String[] args) {

    }
}
