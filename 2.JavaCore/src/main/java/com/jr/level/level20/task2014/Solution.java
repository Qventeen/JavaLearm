package com.jr.level.level20.task2014;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args){
        System.out.println(new Solution(4));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(args[0]));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(args[0]));
            Solution savedObject;
            Solution loadedObject;
            try {
                savedObject = new Solution(-7);
                oos.writeObject(savedObject);
                loadedObject = (Solution) ois.readObject();
            } finally {
                oos.close();
                ois.close();
            }
            System.out.println(savedObject);
            System.out.println(loadedObject);
            System.out.println(savedObject.string.equals(loadedObject.string));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
