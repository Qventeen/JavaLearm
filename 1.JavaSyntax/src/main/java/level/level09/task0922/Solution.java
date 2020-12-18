package level.level09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //Алгоритм
        //Создать ридер
        //Создать формат даты используя нужный паттерн
        //передать в формат строку входных данных
        //создать объект даты преобразуя формат
        //Вывести дату на экран

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String data = rd.readLine();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        try {
            Date date = format.parse(data);
            format.applyPattern("LLL dd, yyyy");
            data = format.format(date);
            System.out.println(data.toUpperCase());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
