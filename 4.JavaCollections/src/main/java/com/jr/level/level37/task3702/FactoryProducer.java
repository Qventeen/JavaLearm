package com.jr.level.level37.task3702;

import com.jr.level.level37.task3702.female.FemaleFactory;
import com.jr.level.level37.task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType factoryType){
        AbstractFactory factory = null;
        switch(factoryType){
            case MALE: factory = new MaleFactory(); break;
            case FEMALE: factory = new FemaleFactory();
        }
        return factory;
    }
}
