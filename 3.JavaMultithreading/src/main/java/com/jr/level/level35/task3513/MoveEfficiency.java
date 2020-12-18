package com.jr.level.level35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if(o == null) return 1;
        if(this == o) return 0;
        int result;
        if((result = Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles)) == 0){
            result = Integer.compare(score, o.score);
        }
        return result;
    }

}
