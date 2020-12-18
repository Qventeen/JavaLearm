package com.jr.level.level31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Path passwords = downloadFile(args[0], Paths.get(args[1]));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path tmp = Files.createTempFile("tmp", "tmp");
        Files.copy(url.openStream(),tmp, StandardCopyOption.REPLACE_EXISTING);
        Path urlFileName = Paths.get(url.getFile()).getFileName();
        downloadDirectory = downloadDirectory.resolve(urlFileName);

        return Files.move(tmp,downloadDirectory);

    }

}
