package level.level04.task0414;

/* 
Количество дней в году
*/

/*
* Каждый
* */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Буфферезированный ввод с клавиатуры
        InputStream is = System.in;
        Reader ir = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(ir);
        String syear = reader.readLine();
        int x = Integer.parseInt(syear);
        final int four_h = 400;
        final int one_h = 100;
        final int four = 4;
        final int visocosniy = 366;
        final int novisocosyiy = 365;
        System.out.println("количество дней в году: ");
        if(x % four_h ==0)
            System.out.println(visocosniy);
        else if(x % one_h == 0)
            System.out.println(novisocosyiy);
        else if(x % four == 0)
            System.out.println(visocosniy);
        else
            System.out.println(novisocosyiy);
    }
}

