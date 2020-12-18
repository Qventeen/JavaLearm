package com.jr.level.level24.task2413;

public class Ball extends BaseObject {
    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    //Приватные поля

    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    //Конструкторы
    public Ball(double x, double y, double speed, double direction){
        super(x,y,1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    //Геттеры

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    //Игровая логика

    @Override
    public void move() {
        if(!isFrozen) {
            this.x += dx;
            this.y += dy;

        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(this.x, this.y, 'O');
    }

    public void start(){
        isFrozen = false;
    }

    public void setDirection(double direction){
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    public void checkRebound(int minx, int maxx, int miny, int maxy){
        this.checkBorders(minx,maxx,miny,maxy);
        setDirection((this.direction + 180) % 360);

    }
}
