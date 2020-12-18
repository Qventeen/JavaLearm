package com.jr.level.level15.task1530;

public abstract class DrinkMaker {
	public abstract void getRightCup();
	public abstract void putIngredient();
	public abstract void pour();
	public void makeDrink(){
		getRightCup();
		putIngredient();
		pour();
	}
}
