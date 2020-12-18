package com.jr.level.level15.task1525;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            BufferedReader rd = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String line = rd.readLine();
            while(line != null){
                lines.add(line);
                line = rd.readLine();
            }
            rd.close();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }

    public static void main(String[] args) {
        System.out.println(lines);

    }
}
