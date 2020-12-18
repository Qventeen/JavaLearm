package com.jr.level.level38.task3810;

public @interface Author {
    String value();
    Position position() default Position.OTHER;
}
