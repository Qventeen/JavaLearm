package com.jr.level.level15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
       BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
       String tmp;
       try {
           tmp = rd.readLine();
           if(Sun.SUN.equals(tmp)){
               thePlanet = Sun.getInstance();
           } else if (Earth.EARTH.equals(tmp)){
               thePlanet = Earth.getInstance();
           } else if (Moon.MOON.equals(tmp)){
               thePlanet = Moon.getInstance();
           } else
               thePlanet = null;
       }catch (IOException e) { /*пустой перехват исключения*/}
    }
}
