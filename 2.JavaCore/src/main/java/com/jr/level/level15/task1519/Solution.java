package com.jr.level.level15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Разные методы для разных типов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String value = rd.readLine();
		List<String> list = new LinkedList<>();
		//Формирование списка значений
		while (!"exit".equals(value)) {
			list.add(value);
			value = rd.readLine();
		}
		for(String str: list){
			printer(str);
		}


	}

	public static void print(Double value) {
		System.out.println("Это тип Double, значение " + value);
	}

	public static void print(String value) {
		System.out.println("Это тип String, значение " + value);
	}

	public static void print(short value) {
		System.out.println("Это тип short, значение " + value);
	}

	public static void print(Integer value) {
		System.out.println("Это тип Integer, значение " + value);
	}

	public static void printer(String value) {
		//проверить на наличие точки
		if (value.contains(".")) {
			try{
				//попытатся получить дабл
				print(Double.parseDouble(value));
				return;
			} catch(NumberFormatException e){
				//оставим ловушку пустой для продолжения
			}
		}
		int n;
		//попытатся получить целое
		try {
			n = Integer.parseInt(value);
			//выяснить диапазон значения целого и вызвать
			//нужную печать
			if (n > 0 && n < 128) {
				print((short) n);
			} else if (n <= 0 || n >= 128) {
				print((Integer) n);
			}
			return;
		} catch (NumberFormatException e){

		}

		print(value);


		}

}
