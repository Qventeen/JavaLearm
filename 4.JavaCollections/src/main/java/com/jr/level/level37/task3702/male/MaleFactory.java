package com.jr.level.level37.task3702.male;

import com.jr.level.level37.task3702.AbstractFactory;
import com.jr.level.level37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age){
        Human human = null;
        if(age >= 0 && age <= KidBoy.MAX_AGE ){
            human = new KidBoy();
        } else if(age <= TeenBoy.MAX_AGE){
            human = new TeenBoy();
        } else
            human = new Man();

        return human;
    }
}
