package com.jr.level.level14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        do
        {
            key = reader.readLine();
            if("user".equals(key)){
                person = new Person.User();
            } else if("loser".equals(key)){
                person = new Person.Loser();
            } else if("coder".equals(key)){
                person = new Person.Coder();
            } else if("proger".equals(key)){
                person = new Person.Proger();
            } else {
                return;
            }

            doWork(person); //вызываем doWork

        } while(true);
    }

    public static void doWork(Person person) {
        if(person instanceof Person.User){
            ((Person.User) person).live();
        } else if(person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        } else if(person instanceof Person.Coder){
            ((Person.Coder)person).coding();
        } else if(person instanceof Person.Proger){
            ((Person.Proger) person).enjoy();
        }
    }
}
