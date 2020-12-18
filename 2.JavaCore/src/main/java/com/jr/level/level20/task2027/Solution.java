package com.jr.level.level20.task2027;

import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {


    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }
    
    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new LinkedList<Word>();
        for(String str: words){
            list.add(detectWord(crossword,str));
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
    //                  Защищенная секция
    //====================================================================

    private static Word detectWord(int [][] crossword, String str) {
        int directions[][] = {
                {1, 0},  //x+1,  y
                {1, 1},  //x+1,  y+1
                {0, 1},  //x,    y+1
                {-1, 1}, //x-1,  y+1
                {-1, 0}, //x-1,  y
                {-1, -1},//x-1,  y-1
                {0, -1}, //x,    y-1
                {1, -1}  //x+1,  y-1
        };
        char[] text = str.toCharArray();
        Word word = new Word(str);
        for(int y = 0; y < crossword.length; y++){
            for (int x = 0; x < crossword[0].length; x++){
                if(text[0] == crossword[y][x]){
                    for(int w = 0; w < directions.length; w++){
                        if(equalsWords(text,crossword,x,y,directions,w)){
                            word.setStartPoint(x,y);
                            word.setEndPoint(
                                    x + (text.length-1) * directions[w][0],
                                    y + (text.length-1) * directions[w][1]
                            );
                            return word;
                        }
                    }
                }
            }
        }
        return word;
    }

    private static boolean equalsWords(char[] word, int[][] tab, int x, int y, int[][] direct, int way) {
        //Вычислить координаты конца слова
        int x2 = x + direct[way][0] * word.length;
        int y2 = y + direct[way][1] * word.length;
        x += direct[way][0];
        y += direct[way][1];

        boolean flag = true;

        //Если конец по даному пути находится в пределах массива
        try {
            for (int wch = 1; wch < word.length; wch++) {
                if(word[wch]!=tab[y][x]){
                    flag = false;
                    break;
                }
                x += direct[way][0];
                y += direct[way][1];

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            flag = false;
        }
        return flag;
    }


}

/*
 * Итак что у нас есть
 *   1 Двумерный массив символов
 *   2 Входящий массив строк
 *   3 Класс Word содержащий
 *      Строку со значением слова
 *      Координаты начала слова в массиве
 *      Координаты конца слова в массиве
 *
 * Задание:
 *   Используя входящий контейнер со строками
 *   Отыскать в массиве символов каждую из строк
 *   Для каждого слова создать объект класси Word
 *   Занести в класс координаты начала и конца каждой строки
 *
 * Условия поиска:
 *   Строки могут располагатся в массиве
 *   1 По горизонтали
 *   2 По вертикали
 *   3 По диагонали
 *   Расположение возможно в обе стороны
 *
 * Допущения:
 *   1 Кроссворд = уникальные слова
 *   2 Проводим поиск первого вхождение каждой строки
 *     согласно условий поиска
 *   3 Каждое искомое слово должно существовать в массиве
 *     Иного в задании не указано.
 *
 *  Заметки:
 *   Как найти строку?
 *   Составить карту направлений поиска (8 направлений)
 *   Получить массив целых из текущей строки поиска
 *   Провести обход массива в поисках первого символа строки
 *       Проверить каждое направление
 *           Если размер слова не выходит за пределы массива по направлению
 *               Выполняем поразрядное сравнение
 *                   Если сравнение удачно
 *                       результат = + 1 слово с координатами
 *    Условия прерывание поиска
 *       Слово найдено          -> ищем новое слово
 *       Направлений больше нет -> ищем следующий начальный символ
 *       Недостаточно размера   -> выбираем следующее неправление
 *       Сравнение неудачно     -> выбираем следующее направление
 *
 *
 *
 *
 *
 *
 *
 *
 */
