package com.jr.level.level18.task1814;

import java.io.FileInputStream;
import java.util.regex.Pattern;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws Exception {
        super(fileName);
        if(Pattern.matches(".*[.]txt$", fileName) == false){
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) {
    }
}

