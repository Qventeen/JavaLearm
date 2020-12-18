package com.jr.level.level35.task3513;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 8;
    private Tile [][] gameTiles;

    int score;
    int maxTile;

    //undo redo options
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

//Constructors
    public Model(){
        resetGameTiles();
    }


//public methods
    void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][];
        for(int i = 0; i < gameTiles.length; i++){
            gameTiles[i] = new Tile[FIELD_WIDTH];
            for(int k = 0; k < gameTiles[i].length; k++){
                gameTiles[i][k] = new Tile();
            }
        }
        addTile();
        addTile();
        maxTile = score = 0;
    }

    //Базовый метод перемещения
    public void left(){
        if(isSaveNeeded) saveState(gameTiles);
        boolean flag = false;
        for(Tile[] tiles: gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                flag = true;
            }
        }
        isSaveNeeded = true;
        if(flag)
            addTile();
    }

    public void right(){
        saveState(gameTiles);
        gameTiles = turnRight(gameTiles);
        gameTiles = turnRight(gameTiles);
        left();
        gameTiles = turnRight(gameTiles);
        gameTiles = turnRight(gameTiles);

    }
    public void up(){
        saveState(gameTiles);
        gameTiles = turnRight(gameTiles);
        gameTiles = turnRight(gameTiles);
        gameTiles = turnRight(gameTiles);
        left();
        gameTiles = turnRight(gameTiles);
    }
    public void down(){
        saveState(gameTiles);
        gameTiles = turnRight(gameTiles);
        left();
        gameTiles = turnRight(gameTiles);
        gameTiles = turnRight(gameTiles);
        gameTiles = turnRight(gameTiles);
    }
    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    public boolean canMove(){
        for(int y = 0; y < gameTiles.length; y++){
           for(int x = 0; x < gameTiles[y].length; x++){
               if(gameTiles[y][x].value == 0)
                   return true;
           }
        }

       for(int y = 0; y < gameTiles.length-1; y++){
           for(int x = 0; x < gameTiles[y].length-1; x++){
               int cT = gameTiles[y][x].value;
               if(  cT == gameTiles[y][x+1].value ||
                    cT == gameTiles[y+1][x].value)
               {
                   return true;
               }
           }
       }
       return false;

    }

    public void rollback(){
        if(!previousScores.isEmpty() && !previousStates.isEmpty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch(n){
            case 0: left();break;
            case 1: right();break;
            case 2: up();break;
            case 3: down();
        }
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency;
        if(!hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(-1,0, move);
        }else{
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveEfficiency;
    }

    public boolean hasBoardChanged(){
        if(previousStates.isEmpty()) return true;
        if(getSumWeightTiles(previousStates.peek()) != getSumWeightTiles((gameTiles)))
            return true;

        return false;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue =
                new PriorityQueue<>(
                        4,
                        Collections.reverseOrder()
                );
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.peek().getMove().move();
    }

//private methods
    private void saveState(Tile[][] stateForSave){
//        if(!this.isSaveNeeded) return;

        Tile[][] tmpTiles = new Tile[stateForSave.length][];
        for(int y = 0; y < tmpTiles.length; y++){
           tmpTiles[y] = new Tile[stateForSave[y].length];
           for(int x = 0; x < tmpTiles[y].length; x++){
              tmpTiles[y][x] = new Tile(stateForSave[y][x].value);
           }
        }
        this.previousStates.push(tmpTiles);
        this.previousScores.push(score);
        this.isSaveNeeded = false;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean flag = false;
        for(int i = 0, k = 1; k < tiles.length;i++,k++){
            //Если вес 2 соседних плиток равнен
            if(tiles[i].value > 0 && tiles[i].value == tiles[k].value){
                flag = true;
                //Соеденить вес этих плиток
                tiles[i].value += tiles[k].value;
                //Увеличить общий счет
                score += tiles[i].value;
                if(tiles[i].value > maxTile)
                    maxTile = tiles[i].value;
                //Обнулить правую плитку из текущей пары
                tiles[k].value = 0;
                //Переместить индексы на полупару
                i++; k++;
            }
        }
        //Выполнить сжатие плиток после объеденения
        compressTiles(tiles);
        return flag;
    }
    /**
     * Поворачивает переданный двумерный массив плиток вправо на 90 градусов
     * @param inputTiles - базовая таблица плиток
     * @return - перевернутое представление базовой таблицы плиток
     * предоставляет возможность манипулировать базовыми объектами
     */
    private Tile[][] turnRight(Tile[][] inputTiles){
        Tile[][] tmpTiles = new Tile[Model.FIELD_WIDTH][];
        //Создаем пустое представление игрового поля
        for(int i = 0; i < tmpTiles.length; i++){
            tmpTiles[i] = new Tile[Model.FIELD_WIDTH];
        }
        //xg yg - координаты х у для игровых плиток
        //xr yr - координаты х у для представления игрового поля
        for(int yg = 0; yg < inputTiles.length; yg++){
            for(int xg = 0, xr = inputTiles[yg].length- 1 - yg, yr = 0; xg < inputTiles[yg].length; xg++, yr++){
                tmpTiles[yr][xr] = inputTiles[yg][xg];
            }
        }
        return tmpTiles;
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> emptyTileList = new ArrayList<>();
        for(Tile[] tiles: gameTiles){
            for(Tile tile: tiles){
                if(tile.isEmpty()){
                    emptyTileList.add(tile);
                }
            }
        }
        return emptyTileList;
    }

    private void addTile(){
        List<Tile> emptyTiles = getEmptyTiles();
        if(!emptyTiles.isEmpty()){
            Tile randomEmptyTile = emptyTiles.get((int) (Math.random()*emptyTiles.size()));
            randomEmptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles){
        boolean flag = false;
        for(int i = 0, k = 1; k < tiles.length; k++){
            if (tiles[i].isEmpty()){
                if(!tiles[k].isEmpty()){
                    tiles[i].value = tiles[k].value;
                    tiles[k].value = 0;
                    i++;
                    flag = true;
                }
            }
            else i++;
        }
        return flag;
    }

    private int getSumWeightTiles(Tile[][] tilesForSum){
        int res = 0;
        for(Tile[] tiles: tilesForSum){
            for(Tile tile: tiles){
                res += tile.value;
            }
        }
        return res;
    }

    private void printModel(){
        for(Tile[] tiles: gameTiles){
            for(Tile tile: tiles){
                System.out.print(tile.value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String [] args){
        Model model = new Model();
        model.printModel();
        for(int i = 0; i < 5; i++){
            model.left();
            model.printModel();
            model.right();
            model.printModel();
            model.up();
            model.printModel();
            model.down();
            model.printModel();
        }

    }
}




