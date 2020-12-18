package com.jr.level.level19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
	private static final int limit = 2;
	public static List<String> words = new ArrayList<String>();

	static {
		words.add("файл");
		words.add("вид");
		words.add("в");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String name = rd.readLine();

		BufferedReader fin = new BufferedReader(new FileReader(name));
		rd.close();
		HashSet<String> set;
		String[] tmp;
		String str;
		int count;
		try {
			while (fin.ready()) {
				count = 0;
				str = fin.readLine();
				tmp = str.split(" ");
				set = new HashSet<String>(Arrays.asList(tmp));
				for(String s: words){
					if(set.contains(s)) count++;
				}
				if (count == limit)
					System.out.println(str);
			}
		} finally {
			fin.close();
		}
	}
}
