package com.jr.level.level31.task3105;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        //Открыть архив и вычитать из него даннные во временную директорию
        FileInputStream fin = new FileInputStream(args[1]);
        ZipInputStream zis = new ZipInputStream(fin);
        Map<String,ByteArrayOutputStream> zipEntryMap = new HashMap<>();
        ZipEntry zipEntry;
        while((zipEntry = zis.getNextEntry()) != null){
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            copyData(zis, buf);
            zipEntryMap.put(zipEntry.getName(), buf);
            zis.closeEntry();
        }

        //Блок закрытия файлов после вычитки
        zis.close();
        fin.close();
        //zos открыть файл для записи
        FileOutputStream fout = new FileOutputStream(args[1]);
        ZipOutputStream zos = new ZipOutputStream(fout);
        Path zipFileName = Paths.get("new").resolve(Paths.get(args[0]).getFileName());
        zipEntry = new ZipEntry(zipFileName.toString());
        if(zipEntryMap.containsKey(zipEntry.getName())) zipEntryMap.remove(zipEntry.getName());
        zos.putNextEntry(zipEntry);
        Files.copy(Paths.get(args[0]), zos);
        zos.closeEntry();

        for(Map.Entry<String,ByteArrayOutputStream> pair: zipEntryMap.entrySet()){
            zos.putNextEntry(new ZipEntry(pair.getKey()));
            zos.write(pair.getValue().toByteArray());
            zos.closeEntry();
        }
        zos.close();
        fout.close();

    }

    public static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[1024];
        int length = -1;
        while((length = in.read(buf,0,buf.length)) > 0){
            out.write(buf,0,length);
        }
    }


}
