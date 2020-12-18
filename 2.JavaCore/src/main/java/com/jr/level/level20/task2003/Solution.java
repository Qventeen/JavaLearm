package com.jr.level.level20.task2003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();
        FileInputStream fin = new FileInputStream(name);
        load(fin);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        for(Map.Entry<Object, Object> pair: p.entrySet()){
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) {

    }
}
