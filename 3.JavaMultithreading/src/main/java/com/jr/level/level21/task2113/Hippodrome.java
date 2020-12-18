package com.jr.level.level21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses(){
        return horses;
    }

    public void run() throws InterruptedException {
        for(int k = 0; k < 100; k++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for(Horse h: horses) {
            h.move();
        }
    }
    public void print(){
        for(Horse h: horses){
            h.print();
        }
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
    }

    public Horse getWinner(){
        int max = 0;
        int res = 0;
        for(int k = 1; k < horses.size(); k++){
            if(horses.get(res).getDistance() < horses.get(k).getDistance()){
                res = k;
            }
        }
        return horses.get(res);
    }
    public void printWinner(){
        Horse win = getWinner();
        System.out.println("Winner is " + win.getName() + '!');
    }

    public static void main(String [] args) throws InterruptedException {
        ArrayList<Horse> hs = new ArrayList<Horse>(3);
        hs.add(new Horse("qventeen0", 3,0));
        hs.add(new Horse("qventeen1", 3,0));
        hs.add(new Horse("qventeen2", 3,0));
        game = new Hippodrome(hs);
        game.run();
        game.printWinner();
    }


}
