package com.jr.level.level17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
	public static List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		if (args.length > 0) {
			try {
				if (args.length == 4 || "-c".equals(args[0])) {
					create(args[1], args[2], sd.parse(args[3]));
				} else if (args.length == 5 || "-u".equals(args[0])) {
					update(Integer.parseInt(args[1]), args[2], args[3], sd.parse(args[4]));
				} else if ("-d".equals(args[0])) {
					delete(Integer.parseInt(args[1]));
				} else if ("-i".equals(args[0])) {
					inform(Integer.parseInt(args[1]));
				} else
					System.out.println("Uncorect input argument");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			System.out.println("No command");
	}
	private static void create(String name, String sex, Date date) {
		if ("м".equals(sex)) {
			allPeople.add(Person.createMale(name, date));
		} else if ("ж".equals(sex)) {
			allPeople.add(Person.createFemale(name, date));
		}
		System.out.println(allPeople.size() - 1);
	}
	private static void update(int id, String name, String sex, Date bd) {
		Person p = allPeople.get(id);
		p.setName(name);
		if ("м".equals(sex))
			p.setSex(Sex.MALE);
		else if ("ж".equals(sex))
			p.setSex(Sex.FEMALE);
		p.setBirthDay(bd);
	}
	private static void delete(int id) {
		Person p = allPeople.get(id);
		p.setBirthDay(null);
		p.setSex(null);
		p.setName(null);
	}
	private static void inform(int id) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
		StringBuilder sb = new StringBuilder();
		Person p = allPeople.get(id);

		sb.append(p.getName());
		sb.append(" ");
		if (p.getSex() == Sex.MALE) {
			sb.append("м");
		} else {
			sb.append("ж");
		}
		sb.append(" ");
		sb.append(df.format(p.getBirthDay()));
		System.out.println(sb.toString());
	}
}
