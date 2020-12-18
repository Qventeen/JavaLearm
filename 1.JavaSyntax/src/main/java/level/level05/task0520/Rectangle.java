package level.level05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int top,
                left,
                width,
                height;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        width = height = 0;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        height = width;
    }
    public Rectangle(Rectangle rc){
        top = rc.top;
        left = rc.left;
        width = rc.width;
        height = rc.height;
    }

    public static void main(String[] args) {

    }
}
