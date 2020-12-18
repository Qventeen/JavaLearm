package com.jr.level.level18.task1813;

import java.io.FileOutputStream;
import java.io.IOException;
/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    FileOutputStream component;
    public AmigoOutputStream(FileOutputStream component) throws  IOException {
            super(component.getFD());
            this.component = component;
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JR © All rights reserved.".getBytes());
        component.close();
    }

    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
