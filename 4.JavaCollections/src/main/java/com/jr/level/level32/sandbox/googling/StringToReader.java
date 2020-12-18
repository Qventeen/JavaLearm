package com.jr.level.level32.sandbox.googling;

import java.io.IOException;
import java.io.StringReader;
import java.io.Reader;
public class StringToReader {
    public static void main(String[] args) throws IOException {
        String string = "Hello World!";
        Reader reader = new StringReader(string);
        reader.close();
    }
}
