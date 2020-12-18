package com.jr.level.level31.task3112;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.zip.*;

public class TestClass {

    public static void main(String[] args) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(Paths.get("/home/qventeen/testZip.zip")));
        Path test = Paths.get("/home/qventeen/test1/");
        System.out.println(test.toString());
        zos.putNextEntry(new ZipEntry(test.getFileName() + File.separator));
        zos.closeEntry();
        zos.close();
    }
}
