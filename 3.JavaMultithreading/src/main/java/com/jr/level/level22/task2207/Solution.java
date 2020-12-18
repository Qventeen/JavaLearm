package com.jr.level.level22.task2207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //Открыть поток чтения из консоли
        BufferedReader crd = new BufferedReader(new InputStreamReader(System.in));
        //Создать путь на базе имени файла
        Path fname = Paths.get(crd.readLine());

        //Получить необходимую кодировку
        Charset set = StandardCharsets.UTF_8;
        //Создать буфферизированный ридер статическим методом класса.
        //Передать path (полное имя файла) и Charset (кодировку)
        BufferedReader fin = Files.newBufferedReader(fname,set);
        StringBuilder sb = new StringBuilder();
        //Строим строку из файла
        while(fin.ready()){
            sb.append(fin.readLine()+ ' ');
        }
        String[] sin = sb.toString().trim().split("\\s+");
        for(int k = 0; k < sin.length-1; k++) {
            if (sin[k] != null) {
                for (int i = k + 1; i < sin.length; i++) {
                    if(sin[i] != null && sin[k].equals(new StringBuilder(sin[i]).reverse().toString())){
                        Pair p = new Pair();
                        p.first = sin[k];
                        p.second = sin[i];
                        sin[k] = null;
                        sin[i] = null;
                        result.add(p);
                        break;
                    }
                }
            }
        }


        System.out.println(result.toString());
    }

    public static class Pair {
        String first;
        String second;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;
//
//            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
//            return second != null ? second.equals(pair.second) : pair.second == null;
              return toString().equals(pair.toString());
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
