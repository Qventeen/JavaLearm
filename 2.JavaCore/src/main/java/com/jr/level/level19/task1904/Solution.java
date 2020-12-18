package com.jr.level.level19.task1904;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            String str = fileScanner.nextLine();
            String[] s = str.split(" ");
            Person p = null;
            try{
                p = new Person(s[1],s[2],s[0],
                 sdf.parse(s[3] + s[4] + s[5]));
            }catch (Exception e){}

            return p;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
