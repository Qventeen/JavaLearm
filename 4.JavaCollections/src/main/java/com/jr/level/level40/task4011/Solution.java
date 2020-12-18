package com.jr.level.level40.task4011;

import java.io.IOException;
import java.net.URL;

import static java.lang.String.format;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) {
        try {
            URL validateURL = new URL(s);
            print(validateURL.getProtocol());
            print(validateURL.getAuthority());
            print(validateURL.getFile());
            print(validateURL.getHost());
            print(validateURL.getPath());
            print(validateURL.getPort());
            print(validateURL.getDefaultPort());
            print(validateURL.getQuery());
            print(validateURL.getRef());
        }catch (IOException e){
            print(format("Parameter %s is not a valid URL.", s));
        }

    }

    private static void print(Object s){
        System.out.println(s);
    }
}

