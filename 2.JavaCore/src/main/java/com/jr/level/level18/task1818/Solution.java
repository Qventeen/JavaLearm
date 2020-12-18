package com.jr.level.level18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        try {
            BufferedWriter fout = new BufferedWriter(new FileWriter(rd.readLine()));
            BufferedReader fin1 = new BufferedReader(new FileReader(rd.readLine()));
            BufferedReader fin2 = new BufferedReader(new FileReader(rd.readLine()));

            try {
                while(fin1.ready()){
					fout.write(fin1.readLine());
				}
                while (fin2.ready()){
					fout.write(fin2.readLine());
				}
            } finally {
                fout.close();
                fin1.close();
                fin2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
