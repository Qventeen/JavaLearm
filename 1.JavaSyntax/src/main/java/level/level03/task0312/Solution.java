package level.level03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
        System.out.println(convertToSeconds(24));
        System.out.println(convertToSeconds(8));
    }
    
    public static int convertToSeconds(int hour){
        return hour*3600;
    }
}
