package com.jr.level.level33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;


public class Helper {
    public static String generateRandomString(){
        return new BigInteger(150, new SecureRandom()).toString(36);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }


}
