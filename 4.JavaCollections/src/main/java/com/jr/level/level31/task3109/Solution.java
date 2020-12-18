package com.jr.level.level31.task3109;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Path propertiesPath = Paths.get(fileName);
        Properties result = new Properties();

        try {
            InputStream ISP = Files.newInputStream(propertiesPath);
            if(propertiesPath.getFileName().toString().endsWith(".xml")){
                result.loadFromXML(ISP);
            }else{
                result.load(ISP);
            }
        } catch (IOException e) {}

        return result;
    }
}
