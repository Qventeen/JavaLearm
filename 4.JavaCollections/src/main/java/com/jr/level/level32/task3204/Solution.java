package com.jr.level.level32.task3204;


import java.io.ByteArrayOutputStream;
import java.util.*;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    static Set<String> oldPasswords = new HashSet<>();
    static String[] strings = new String[3];
    static {
        strings[0] = "abcdefghijklmnopqrstuvwxyz";
        strings[1]="ABCDEFGHIJKLMMOPQRSTUVWXYZ";
        strings[2]="0123456789";
    }
    public static ByteArrayOutputStream getPassword() {
        final int PASSLEN = 8;
        Random rd = new Random(new Date().getTime());
        ByteArrayOutputStream bos = new ByteArrayOutputStream(PASSLEN);
        int x,y;
        do {
            bos.reset();
            for (int i = 0; i < PASSLEN; i++) {
                x = rd.nextInt(3);
                y = rd.nextInt(strings[x].length());
                bos.write((byte) (strings[x].charAt(y)));
            }
        }while(!testGen(bos.toString()));
        return bos;
    }

    private static boolean testGen(String str){
        if(!str.matches(".*[a-z]+.*")) return false;
        if(!str.matches(".*[A-Z]+.*")) return false;
        if(!str.matches(".*[0-9]+.*")) return false;
        if(oldPasswords.contains(str)) return false;

        oldPasswords.add(str);
        return true;
    }

}
