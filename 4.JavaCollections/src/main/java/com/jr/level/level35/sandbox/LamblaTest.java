package com.jr.level.level35.sandbox;

import java.util.function.Function;
import java.util.function.Supplier;

public class LamblaTest {
    public static void main(String[] args) {
        Supplier<String> supplier = String::new;
        Supplier<String> supplier2 = () -> "";
        Function<String,String> function = String::new;
        function.apply("hello");
    }
}
