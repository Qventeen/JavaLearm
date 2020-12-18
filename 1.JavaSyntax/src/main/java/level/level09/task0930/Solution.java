package level.level09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        //Дано массив
        //задание сортировать по критериям:
            // если строка сортировать по алфавиту
            // если число сортировать по убыванию
        String tmp = null;
        for (int i = 0; i < array.length-1; i++) {
            if(isNumber(array[i])) {
                for (int j = i + 1; j < array.length; j++) {
                    if(isNumber(array[j]) &&
                      Integer.parseInt(array[j]) > Integer.parseInt(array[i])){

                        tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                    }
                }
            } else {
                for (int j = i+1; j < array.length ; j++) {
                    if(!isNumber(array[j]) && isGreaterThan(array[i], array[j])){
                        tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
