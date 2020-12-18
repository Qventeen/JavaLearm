package com.jr.level.level18.task1826;

/* 
Шифровка
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length < 3) return;

        BufferedInputStream fin = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(args[2]));
        switch(args[0]){
            case "-e": encrypt(fin, fout); break;
            case "-d": decrypt(fin, fout); break;
            default:
                System.out.println("Некорректная команда");
        }
        fin.close();
        fout.close();
    }


    public static void encrypt(BufferedInputStream in, BufferedOutputStream eout){
        Random rand = new Random(47);
        int bseed = (byte) rand.nextInt();
        try {
            eout.write(bseed);
            for (int i = 0; in.available() > 0 ; i++) {
                eout.write((in.read()+bseed+i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decrypt(BufferedInputStream ein, BufferedOutputStream out){
        try{
            int bseed = ein.read();
            for (int i = 0; ein.available() > 0; i++) {
                out.write(ein.read() - bseed - i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
