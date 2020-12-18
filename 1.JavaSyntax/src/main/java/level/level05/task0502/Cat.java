package level.level05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int ipower = this.weight * this.strength;
        int youpower = anotherCat.weight * anotherCat.strength;
        if(ipower > youpower)
            return true;
        return false;

    }

    public static void main(String[] args) {

    }
}
