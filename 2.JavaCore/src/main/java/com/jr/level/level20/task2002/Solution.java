package com.jr.level.level20.task2002;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JR
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            OutputStream outputStream = new FileOutputStream(args[0]);
            InputStream inputStream = new FileInputStream(args[0]);

            JR JR = new JR();

            JR.save(outputStream);
            outputStream.flush();

            JR loadedObject = new JR();
            loadedObject.load(inputStream);

            if(JR.equals(loadedObject)){
                System.out.println("Опять все ОК");
            } else {
                System.out.println("Мой друг! Соберись и поведай мне лучшую историю");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JR {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintStream ps = new PrintStream(outputStream);
            ps.println(users.size());
            for(User u: users){
                u.save(ps);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(rd.readLine());
            User tmp;
            while(size-- > 0){
                tmp = new User();
                tmp.load(rd);
                users.add(tmp);
            }


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JR JR = (JR) o;

            return users != null ? users.equals(JR.users) : JR.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
