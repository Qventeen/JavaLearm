package com.jr.level.level31.task3106;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //Создаем и сортируем пути к кусочкам архива
        List<Path> pathList = new ArrayList<>();
        for(int i = 1; i < args.length; i++){
            pathList.add(Paths.get(args[i]));
        }
        pathList.sort(Comparator.naturalOrder());

        //Создаем хранилище-вектор файловых входных потоков
        Vector<InputStream> pathVector = new Vector<>();
        for(Path p: pathList){
           pathVector.add(Files.newInputStream(p));
        }
        //Создаем последовательный входной поток (для выполнения условия задачи
        SequenceInputStream seqInputStream = new SequenceInputStream(pathVector.elements());

        //На основе последовательного потока создаем входной архивный поток
        //из которого будем читать архивных данных
        ZipInputStream zis = new ZipInputStream(seqInputStream);
        ZipEntry zipEntry = zis.getNextEntry();
        //Создать поток итогового файла
        FileOutputStream fos = new FileOutputStream(args[0]);

        //Копировать данные из архива в итоговый файл
        copyData(zis,fos);
        zis.closeEntry();
        //Закрыть потоки вывода
        zis.close();
        fos.close();

    }

    public static void copyData(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[1024 * 8];
        int length = -1;
        while ((length = is.read(bytes, 0, bytes.length)) > 0) {
            os.write(bytes, 0, length);
        }
    }
}


