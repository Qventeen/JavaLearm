package com.jr.level.level33.task3310.strategy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;



public class FileBucket {
    private Path path;

    /**
     * Constructor for create bucket as tmpFile in tmpDir
     */
    public FileBucket() {
        try {
            this.path = Files.createTempFile("fb", "tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get file size for this FileBucket on disk
     * @return size of Bucket
     */
    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Append new entry to BucketFile on a disk
     * @param entry element for serialization on disk
     */
    public void putEntry(Entry entry){
        //Create buffered stream for object stream
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(Files.newOutputStream(path))))
        {
            oos.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get entry from FileBucket that is in tmpFile on a disk
     * @return
     */
    public Entry getEntry(){
        if(getFileSize() == 0){
            return null;
        } else {
            //Create buffered stream for object stream
            try (ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(Files.newInputStream(path))))
            {
                return (Entry) ois.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

        }
        return null;
    }

    /**
     * Remove file for current FileBucket
     */
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
