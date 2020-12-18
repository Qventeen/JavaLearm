package com.jr.level.level35.task3507;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        if (!pathToAnimals.endsWith(File.separator)) {
            pathToAnimals = pathToAnimals.concat(File.separator);
        }

        //Получить список файлов
        String[] classNames = Paths.get(pathToAnimals).toFile().list((dir, name) -> name.endsWith(".class"));

        //Расширение ClassLoader
        String finalPathToAnimals1 = pathToAnimals;
        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                byte[] classBytes;
                try {
                    classBytes = Files.readAllBytes(Paths.get(finalPathToAnimals1, name));
                    Class<?> clazz = defineClass(null, classBytes, 0, classBytes.length);
                    return clazz;
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Set<Animal> animals = new HashSet<>();
        for (String name : classNames) {
            try {
                Class<?> clazz = loader.loadClass(name);
                Object tmp = clazz.newInstance();
                if (tmp instanceof Animal) {
                    animals.add((Animal) tmp);
                }
            } catch (Exception e) {//do nothing}
            }
        }
        return animals;
    }
}


