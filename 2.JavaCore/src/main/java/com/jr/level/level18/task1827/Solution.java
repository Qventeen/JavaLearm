package com.jr.level.level18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length < 4) return;
        if(!"-c".equals(args[0])) return;
        //размеры полей
        int [] len = new int[] {8, 30, 8, 4};
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        //поток для записи
        BufferedWriter fout = new BufferedWriter(new FileWriter(name,true));

        //файл в строку
        String fs = fileToString(name);
        String[] rows = fs.split("\n");

        //последняя строка файла должна иметь наибольший индекс
        //TODO:Организовать поиск наибольшего индекса асли файл не упорядочен
        Integer idmax = idRow(rows[rows.length-1]);
        idmax = idmax + 1; //следующий индекс в прайсе

        //дописать поля в файл
        try {
            fout.write("\n");
            fout.write(pole(idmax.toString(), len[0]));
            for (int i = 1; i < args.length; i++) {
				fout.write(pole(args[i], len[i]));
			}
        } finally {
            fout.close();
        }

    }
    public static String fileToString(String name) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader(name));
        StringBuffer sb = new StringBuffer();
        while(fin.ready()){
            sb.append(fin.readLine() + "\n");
        }
        fin.close();
        return sb.toString();
    }
    public static Integer idRow(String idPars){
        String tmp = idPars.substring(0,8);
        tmp = tmp.split("\\s+")[0];
        Integer itmp = Integer.parseInt(tmp);
        return itmp;
    }

    public static String pole(String string, int len){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if(i < string.length()){
                sb.append(string.charAt(i));
            }
            else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}


/*
* Дано
* Сртуктурированный файл данных
* Каждое поле имеет зданную длинну
* Конец поля если есть заполняется пробелами
* Входные параметры = строки
*
* Имеем символьный файл
* Значит нужен символьный ввод-вывод
*
* Задание:
* Построить запись в файл по заданным в задании условии
* каждое поле имеет строго определенный размер
* каждая строка параметра записывается в заданное поле заданным порядком
* если строка больше размера поля она обрезается иначе заполняется пробелами
*
*
*
* */
