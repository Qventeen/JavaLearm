package com.jr.level.level15.task1522;

public class Sun implements Planet {
	//инициализируется при первом обращении к классу
	//единственный метод для обращения
	//getInstance() посему первый вызов метода
	//единожды инициализирует переменную вызовом конструктора
	//остальное время он просто передает ссылку на переменную
	//наружу
	private static Sun instance;
	private Sun(){}
	public static Sun getInstance(){
		if(instance == null)
			instance = new Sun();
		return instance;
	}

}
