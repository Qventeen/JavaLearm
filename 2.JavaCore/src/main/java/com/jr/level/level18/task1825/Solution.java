package com.jr.level.level18.task1825;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args)  throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Set<String> fileNames = new TreeSet<>(new FilePartComparator());
        //читаем набар имен файлов
        String tmpname = rd.readLine();
        String finname = tmpname;
        while(!"end".equals(tmpname)){
            fileNames.add(tmpname);
            tmpname = rd.readLine();
        }
        //Вычисляем требуемое имя файла
        //Создаем поток записи

        BufferedOutputStream fout = new BufferedOutputStream(
                new FileOutputStream(
                        (finname.split(".part"))[0]
                )
        );

        //создаем поток чтения для каждого файла согласно сортировки
        BufferedInputStream fin;
        for(String sn: fileNames){

            //открываем часть файла для чтения
            fin = new BufferedInputStream(new FileInputStream(sn));
            while(fin.available() > 0){
                //копируем байт за байтом в поток вывода
                fout.write(fin.read());
            }
            fin.close();
        }
        fout.close();
    }
    public static class FilePartComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            if(o1 == null || o2 == null) throw new NullPointerException();
            String[] s1 = o1.split(".part");
            String[] s2 = o2.split(".part");
            int oi1 = Integer.parseInt(s1[s1.length-1]);
            int oi2 = Integer.parseInt(s2[s2.length-1]);
            return Integer.compare(oi1, oi2);
        }
    }
}

/*
* Имеем
* Набор из частей 1 файла
* Каждая чисть = Имя.partN
* Находятся в одной папке (то есть == абсолютный путь)
*
* Нужно
* считать с консоли имена всех частей пока не получим end
* отсортировать имена по возрастанию
*
* создать поток записи с именем файла без суфикса partN
* записать побайтно все части в созданный файл
*
* чтение запись буфферизированная
* закрыть все потоки
* */
