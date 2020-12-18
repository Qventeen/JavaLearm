package com.jr.level.level18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        byte[] buf = new byte[fin.available()];
        fin.read(buf);
        fin.close();
        String str = new String(buf);

        //главное нужное регулярное выражение
        //выражение должно вернуть только 1 строку
        //знаем структуру получим строку;
        for(String s: str.split("\n")){
            if(s.startsWith(args[0] + " ")){
                System.out.println(s);
            }
        }

        //Класное но не подходящее решение
//        //Для него нужен бинарник а он символьный
//        DataInputStream fin = new DataInputStream(
//                new BufferedInputStream(
//                        new FileInputStream(rd.readLine())
//                )
//        );
//        TreeMap<Integer, String> map = new TreeMap<>();
//        while(fin.available() > 0){
//            map.put(fin.readInt(), fin.readUTF());
//        }
//        System.out.println(args[0] + map.get(args[0]));

    }
}
/*Итак что у меня есть
* Построчный структурированный файл
* Каждая строка запись в базе данных
* id productName price quantity
*
* Задание
* Найти и вывести на экран строку с заданным id
*
* Вариант решения
* Считать в буфер байтов весь файл
* Создать строку из байтов
* Построить подходящее регулярное выражение
* Выполнить срез строки соответствующий искомой записи
*
* Вариант решения 2 (крутой)
* Открыть поток чтения DataInputStream
* выполнять следующий алгоритм чтения
*   читаем ИНТ
*   читаем остальную строку
*   выполняем запись в словарь по ключу инт
* находим нужную запись по ключу
*
* */
