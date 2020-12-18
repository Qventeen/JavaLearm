package com.jr.level.level19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        //Подготовка
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String nfile1 = rd.readLine();
        String nfile2 = rd.readLine();
        rd.close();
        BufferedReader f1 = new BufferedReader(new FileReader(nfile1));
        BufferedReader f2 = new BufferedReader(new FileReader(nfile2));
        ArrayList<String> f1tmp = new ArrayList<>();
        ArrayList<String> f2tmp = new ArrayList<>();
        while (f1.ready()) f1tmp.add(f1.readLine());
        f1.close();

        while (f2.ready()) f2tmp.add(f2.readLine());
        f2.close();
        int index = 0;
        for (String s : f1tmp) {
            if (s.equals(f2tmp.get(index))) {
                lines.add(new LineItem(Type.SAME, s));
                index++;
            } else if (s.equals(f2tmp.get(index + 1))) {
                lines.add(new LineItem(Type.ADDED, f2tmp.get(index)));
                lines.add(new LineItem(Type.SAME, s));
                index += 2;
            } else
                lines.add(new LineItem(Type.REMOVED, s));
        }
        
        for (int i = index; i < f2tmp.size() ; i++) {
            lines.add(new LineItem(Type.ADDED, f2tmp.get(i)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

/*
* Для каждой строки ф1
* если ф1 == ф2 SAME ф1 ф2++
* иначе если ф1 == ф2+1 -> ADDEN ф2 -> SAME ф1 и ф2+1 -> ф2 += 2
* иначе REMOVED ф2
* Пока не закончен ф2
*
* */

/*
* Главный механизм
* Дано
* Файлы не имеют пустых строк
* Файл1 оригинал
* Файл2 отредактирован
* Если Строка ф1 == ф2 тогда SAME
* Иначе
*   Если ф1 == ф2+1 -> ADDED
*   Иначе -> REMOVED
*
*
* */
