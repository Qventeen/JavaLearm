package com.jr.level.level31.task3101;

import java.io.*;
import java.util.Random;

public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }

    public static void deleteDirectory(File deletinFiles){
        if(deletinFiles.isDirectory()){
            for(File file: deletinFiles.listFiles()){
                if(!file.isDirectory())
                    file.delete();
                else {
                    deleteDirectory(file);
                    file.delete();
                }
            }
        }
    }

    public static void createRandomFileArea(File targetPath, int deep) throws IOException, FileNotFoundException {
        if(deep <= 0) return;
        targetPath.mkdirs();
        if(targetPath.isDirectory()){
            String alphabetic = "abcdefghigklmonpqrstuvwxyzABCDEFGHIJKLMOPOQRSTUVWXYZ";
            char[] chars = alphabetic.toCharArray();

            Random rand = new Random();
            int b = rand.nextInt(18)+1;
            for(int i = 0; i < b; i++){
                File tmp = new File(targetPath.getAbsolutePath() + '/' + i);
                if(rand.nextInt(11) > 8 ){
                    createRandomFileArea(tmp, deep -1);
                }
                else{
                    BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp)));
                    int d = rand.nextInt(100)+1;
                    for(int k = 0; k < d; k++){
                        fout.write(chars[rand.nextInt(chars.length)]);
                    }
                    fout.close();
                }
            }




        }
    }
}
