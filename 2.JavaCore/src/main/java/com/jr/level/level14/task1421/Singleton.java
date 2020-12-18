package com.jr.level.level14.task1421;

public class Singleton {
	//скрытый конструктор
	private Singleton(){}
	//скрытая статическая переменная класа
	private static Singleton instance = new Singleton();
	//возврат ссылки на единственный класс
	public static Singleton getInstance(){
		return instance;
	}
}
