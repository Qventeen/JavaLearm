package com.jr.level.level17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    /*Описание шагов алгоритма
    * Главное задание разбор параметроа командной строки
    * Определяем входящую команду оператором выбора
    * Заключаем выполнение операции в блок синхронизации по общему ресурсу
    * Выполняем указанную операцию в цикле
    * Выполнение каждой отдельной операции можно включить в отдельный метод
    * */
    public static void main(String[] args) {
        if(args.length == 0) return;
        switch(args[0]){
            case "-c":
                synchronized (allPeople) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    for (int i = 3; i < args.length; i += 3) {
                        System.out.println(create(args[i-2], args[i-1], args[i]));
                    }
                    break;
                }
            case "-u":
                synchronized(allPeople) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    for (int i = 4; i < args.length; i += 4) {
                        update(args[i-3], args[i-2], args[i-1], args[i]);
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        delete(args[i]);

                        }
                    break;
                }
            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        inform(args[i]);
                    }
                    break;
                }
        }

    }
    private static int create(String name, String sex, String bd){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = df.parse(bd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if("м".equals(sex)){
            allPeople.add(Person.createMale(name,date));
        }else{
            allPeople.add(Person.createFemale(name, date));
        }
        return allPeople.size()-1;
    }

    private static void update(String id, String name, String sex, String bd){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try{
            date = df.parse(bd);
        }catch (ParseException e){
            e.printStackTrace();
        }
        Person p = allPeople.get(Integer.parseInt(id));
        p.setName(name);
        p.setBirthDay(date);
        if("м".equals(sex)) p.setSex(Sex.MALE);
        else                p.setSex(Sex.FEMALE);

    }

    private static void delete(String id){
        Person p = allPeople.get(Integer.parseInt(id));
        p.setBirthDay(null);
        p.setSex(null);
        p.setName(null);
    }

    private static void inform(String id){
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        Person person = allPeople.get(Integer.parseInt(id));
        sb.append(person.getName());
        sb.append(" ");
        sb.append(person.getSex() == Sex.MALE ? "м " : "ж ");
        sb.append(df.format(person.getBirthDay()));

        System.out.println(sb.toString());
    }



}
