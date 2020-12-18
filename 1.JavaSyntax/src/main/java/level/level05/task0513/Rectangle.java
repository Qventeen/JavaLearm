package level.level05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    private int top, left, width, height;

    public void initialize(int left, int top, int widht, int height){
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = height;
    }

    public void initialize(int left, int top){
        this.left = left;
        this.top = top;
        width = height = 0;
    }

    public void initialize(int left, int top, int width){
        this.left = left;
        this.top = top;
        this.width = width;
        height = this.width;
    }
    public void initialize(Rectangle rc){
        left = rc.left;
        top = rc.top;
        width = rc.width;
        height = rc.height;
    }

    public static void main(String[] args) {

    }
}
