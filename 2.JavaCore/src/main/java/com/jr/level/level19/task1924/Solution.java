package com.jr.level.level19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
	public static Map<Integer, String> map = new HashMap<Integer, String>();

	static {
		map.put(0, "ноль");
		map.put(1, "один");
		map.put(2, "два");
		map.put(3, "три");
		map.put(4, "четыре");
		map.put(5, "пять");
		map.put(6, "шесть");
		map.put(7, "семь");
		map.put(8, "восемь");
		map.put(9, "девять");
		map.put(10, "десять");
		map.put(11, "одиннадцать");
		map.put(12, "двенадцать");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String name = rd.readLine();

		rd.close();
		BufferedReader fin = new BufferedReader(new FileReader(name));
		StringBuffer result = new StringBuffer();
		String[] tmp;
		int key;
		while (fin.ready()) {
			//string to words
			tmp = fin.readLine().split("\\s");
			//check on number from map
			for (String s : tmp) {
				try {
					key = Integer.parseInt(s);
				} catch (NumberFormatException e) {
					key = -1; // за рамками диапазона
				}
				if (map.containsKey(key)) {
					result.append(map.get(key));
				} else
					result.append(s);
				result.append(' ');
			}
			result.append('\n');
		}
		fin.close();
		result.delete(result.length()-2, result.length()); // delete last '\n'
		System.out.println(result.toString());
	}
}

/*
 * Упорядочить мысли
 * Есть
 *   Файл
 *   Словарь с текстом чисел [0-12]
 *   Нужно преобразовать в слова числа из словаря
 *
 *   Для этого нужно
 *       Построчно читать файл
 *       Разбить каждую строку на слова
 *       Заменить каждое подходящее число словом из словаря
 *       Попутно строя строку
 *       В конце каждой строки добавить \n
 *       Вывести строку в консоль
 *
 * */
