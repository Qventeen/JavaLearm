package com.jr.level.level32.sandbox.interview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class IOStreamsAndRW {
    public static void main(String[] args) {
        ByteArrayInputStream bais = new ByteArrayInputStream("Hello World!".getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    }
}
