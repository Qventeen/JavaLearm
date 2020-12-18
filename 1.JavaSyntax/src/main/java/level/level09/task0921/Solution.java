package level.level09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        List<Integer> integers = new ArrayList<>();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(true) {
                integers.add(Integer.parseInt(rd.readLine()));
            }

        }
        //перехватываем RuntimeException and IOException
        catch (Exception ex){
            for(int i: integers){
                System.out.println(i);
            }
        }
    }
}
