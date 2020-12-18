package com.jr.level.level38.task3810;


public @interface Revision {
    int revision();
    Date date();
    Author[] authors() default  {};
    String comment() default "";
}
