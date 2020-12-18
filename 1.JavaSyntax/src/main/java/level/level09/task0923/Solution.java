package level.level09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String in = rd.readLine();
        List<Character> glas = new LinkedList<>();
        List<Character> soglas = new LinkedList<>();
        for(Character ch: in.toCharArray()){
            if(isVowel(ch)){
                glas.add(ch);
            }else{
                if(!Character.isSpaceChar(ch))
                    soglas.add(ch);
            }
        }
        for(Character ch: glas){
            System.out.print(ch + " ");
        }
        System.out.println();
        for(Character ch: soglas){
            System.out.print(ch + " ");
        }


    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
