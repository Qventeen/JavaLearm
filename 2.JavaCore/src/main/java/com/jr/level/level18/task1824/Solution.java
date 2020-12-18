package com.jr.level.level18.task1824;

/* 
Файлы и исключения
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<FileInputStream> readers = new LinkedList<>();
        String name = "";
        try{
            while(true) {
                name = rd.readLine();
                FileInputStream tmp = new FileInputStream(name);
                readers.add(tmp);
            }
        }catch(FileNotFoundException e){
            System.out.println(name);
        } finally {
            for (FileInputStream fin : readers) {
                fin.close();
            }
        }
    }
}
