package level.level05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name = null;
    private int age = 0;
    private int weight = 0;
    private String address = null;
    private String color = null;

    //one
    public Cat(String name){
        this.name = name;
        age = 1;
        weight = 1;
        color = "Black";
    }
    //two
    public Cat(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "Black";

    }
    //thry
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 1;
        this.color = "Black";
    }
    //four
    public Cat(int weight, String color){
        this.age = 1;
        this.weight = weight;
        this.color = color;
    }
    //five
    public Cat(int weight, String color, String address){
        this.age = 1;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }


    public static void main(String[] args) {

    }
}
