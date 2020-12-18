package com.jr.level.level36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/jr/level/level36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        String nameDir = packageName.endsWith(File.separator) ? packageName : packageName + File.separator;
        Path path = Paths.get(nameDir);

        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                byte [] bytes = loadClassData(name);
                return defineClass(null, bytes, 0, bytes.length);
            }

            private byte[] loadClassData(String name){
                try {
                    return Files.readAllBytes(Paths.get(name));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                return null;
            }
        };

        try {
            List<String> classes = Files.list(path)
                    .map(Path::toFile)
                    .map(File::getName)
                    .filter(n -> n.endsWith(".class"))
                    .map(nameDir::concat)
                    .collect(Collectors.toList());

            for (String name: classes){
                Class<?> clazz = loader.loadClass(name);
                if(HiddenClass.class.isAssignableFrom(clazz)){
                    this.hiddenClasses.add(clazz);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        Class<?> clazz = hiddenClasses.stream().filter(e -> e.getSimpleName().toLowerCase().startsWith(key.toLowerCase())).findFirst().orElse(null);
        try {
            if(clazz != null){
                Constructor constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);

                return (HiddenClass) constructor.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

