package com.jr.level.level32.sandbox.googling;

import java.io.StringWriter;
import java.io.Writer;
import java.io.IOException;

public class WriterToString {
    public static void main(String[] args) throws IOException {
        Writer writer = new StringWriter();
        writer.write("Hello world!");
        writer.close();
        String resultWrite = writer.toString();
        System.out.println(resultWrite);
    }
}
