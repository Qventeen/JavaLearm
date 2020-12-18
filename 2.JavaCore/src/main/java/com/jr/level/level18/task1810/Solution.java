package com.jr.level.level18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(rd.readLine());
        while(fin.available() >= 1000){
            fin.close();
            fin = new FileInputStream(rd.readLine());
        }
        fin.close();
        throw new DownloadException();


    }

    public static class DownloadException extends Exception {

    }
}
