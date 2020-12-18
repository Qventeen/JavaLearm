package level.level10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        //Создать строковый буффер
        StringBuffer buf = new StringBuffer();
        for(String s : list){
            buf.append(s.toLowerCase());
        }
        String s = buf.toString();
        //Внешний цикл
        int count = 0;
        int index = -1;
        for(char ch: abcArray){
            do{
                index = s.indexOf(ch, index +1);
                count++;
            } while(index>=0);
            System.out.println(ch + " " + (count-1));
            count = 0;
            //index всегда = -1 после цикла проверок
        }
        // Пока алфавит
        //Пока индекс поиска корректен
        //получить индекс первого вхождения символа начиная и индекса

    }

}
