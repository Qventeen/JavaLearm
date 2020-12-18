package com.jr.level.level20.task2022;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String filename;
    public Solution(String fileName) throws FileNotFoundException {
        this.filename = fileName;
        this.stream = new FileOutputStream(this.filename);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.filename, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        System.out.println(this.hashCode());
        stream.close();
    }

    public static void main(String[] args)  {
        try (Solution sol = new Solution(args[0])) {
            sol.writeObject("Hello World!");
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bout);
            oos.writeObject(sol);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));

            try(Solution sol2 = (Solution) ois.readObject()) {
                sol2.writeObject("Hello World 2!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
