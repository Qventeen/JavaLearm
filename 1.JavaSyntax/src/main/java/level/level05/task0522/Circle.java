package level.level05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x, double y) {
        this(x, y, 1);
    }

    public Circle(double x) {
        this(x, 0, 1);
    }

    public Circle() {
        this(0,0,1);

    }

    public static void main(String[] args) {

    }
}
