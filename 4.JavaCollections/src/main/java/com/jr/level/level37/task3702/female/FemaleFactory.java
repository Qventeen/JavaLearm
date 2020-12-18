package com.jr.level.level37.task3702.female;

import com.jr.level.level37.task3702.AbstractFactory;
import com.jr.level.level37.task3702.Human;

public class FemaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age){
        Human human;
        if(age <= KidGirl.MAX_AGE){
            human = new KidGirl();
        } else if(age <= TeenGirl.MAX_AGE){
            human = new TeenGirl();
        } else {
            human = new Woman();
        }
        return human;
    }
}
