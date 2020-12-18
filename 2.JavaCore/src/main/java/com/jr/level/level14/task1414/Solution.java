package com.jr.level.level14.task1414;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String key;
        Movie movie;
        do{
            key = rd.readLine();
            movie = MovieFactory.getMovie(key);

            if(movie == null) return;

            System.out.println(movie.getClass().getSimpleName());


        } while(true);
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if("cartoon".equals(key)){
                movie = new Cartoon();
            } else if("thriller".equals(key)){
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }

    //Напишите тут ваши классы, пункт 3
}
