package com.jr.level.level22.task2211;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/*
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows_1251 = Charset.forName("Windows-1251");
        Charset utf_8 = Charset.forName("UTF-8");
        BufferedInputStream finwindows = new BufferedInputStream(new FileInputStream(args[0]));
        BufferedOutputStream foutUtf = new BufferedOutputStream(new FileOutputStream(args[1]));
        byte [] buf = new byte[1000];
        String tmp;
        int count = 0;
        while(finwindows.available()>0){
            count = finwindows.read(buf);
            tmp = new String(buf,0,count,windows_1251);
            foutUtf.write(tmp.getBytes(utf_8));
        }
        finwindows.close();
        foutUtf.close();
    }
}
