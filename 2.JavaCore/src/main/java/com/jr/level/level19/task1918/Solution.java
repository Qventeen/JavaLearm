package com.jr.level.level19.task1918;
/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) throws IOException {
		//подготовка
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String fname = rd.readLine();
		rd.close();
		rd = new BufferedReader(new FileReader(fname));
		//чтение входного файла
		StringBuffer sb = new StringBuffer();
		while (rd.ready()) {
			sb.append(rd.readLine());
		}
		rd.close();
		FindTag ft = new FindTag(sb.toString());
		for(String s: ft.find(args[0])){
			System.out.println(s);
		}
	}
	public static class FindTag {
		private String src;
		private ArrayList<Integer> pos;
		private ArrayList<Character> marks;
		private ArrayList<String> result = new ArrayList<>();

		public FindTag(String src){
			this.src = src;
		}
		public ArrayList<String> find(String tag){
			Matcher Mopen = Pattern.compile("<" + tag + "(>|\\s+.*?>)").matcher(src);
			Matcher Mexit = Pattern.compile("</" + tag + ">").matcher(src);
			//позиции начал и концов тегов в файле уникальны посему отлично подойдет Map
			TreeMap<Integer, Character> map = new TreeMap<>();
			while (Mopen.find() && Mexit.find()) {
				map.put(Mopen.start(), 's');
				map.put(Mexit.end()-1, 'e'); //конец включительно дабы обеспечить уникальность позиций
			}
			pos = new ArrayList<>(map.keySet());
			marks = new ArrayList<>(map.values());
			finder(pos.size()-1);
			Collections.reverse(result);
			return result;
		}
		private int finder(int e) {
			int tmp;
			while (e >= 0 && (marks.get(e)) == 'e') {
				tmp = finder(e - 1);
				result.add(src.substring(pos.get(tmp),pos.get(e) + 1));
				e = tmp - 1;
			}
			return e;
		}
	}
}

/*
 * Будем озвучивать задачу
 * У меня есть последовательность меток начала и конца каждого тега
 * Пройдя по последовательности можно подсчетом меток определить получить диапазон тега
 * Как быть с вложенными
 * Можно использовать рекурсию
 *   Но как быть с правильным порядком следования вывода
 *
 * Вывод
 *   Выводим теги последовательно
 *   Найдя вложенный тег выводим его
 *       Потом перечень подтегов + вложенные
 *
 *   Рекурсия дает возможность построить список подстрок вывода
 *   Особенность рекурсия должна двигатся в направлении с конца к началу
 *   поскольку 1 выводится самая глубокая строка а выводится она должна последней
 *   отсюда двигаясь по подстрокам в обратном направлении строим список вывода
 *   Затем выводим список с конца к началу получая требуемый вывод
 *
 *   Как организовать рекурсию
 *   Рекурсия это метод вызывающий сам себя
 *   Рекурсия должна иметь входные параметры и обязательное условие завершения
 *   Полем для подстрок будет входная строка HTML документа
 *   количества s == e в массиве меток
 *   значит
 *   Движемся по массиву меток reverse
 *       каждая e = рекурсия
 *       каждая s = выход из рекурсии
 *       Return значение найденного e
 *
 *
 *
 *
 *
 *
 * Пометки:
 *   string - строка для поиска тега
 *   startnext - начало следующего тега
 *
 * */

