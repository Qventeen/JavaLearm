package com.jr.level.level37.task3712;

public abstract class Game {

    public void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }

    public abstract void prepareForTheGame();
    public abstract void playGame();
    public abstract void congratulateWinner();
}
