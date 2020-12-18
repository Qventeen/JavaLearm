package com.jr.level.level16.task1630;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    //блок статической инициализации
    static {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = rd.readLine();
            secondFileName = rd.readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //дождатся завершения текущего потока
        f.join();
        System.out.println(f.getFileContent());

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fulFileName = "no name file"; //полное имя файла
        //буффер файла
        private StringBuffer buf = new StringBuffer();

        @Override
        public void run(){
            BufferedReader rd;
            try {
                //открытие файла по переданнаму
                rd = new BufferedReader(new FileReader(this.fulFileName));
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден:" + fulFileName );
                throw new RuntimeException(e);
            }
            String str;
            //Попытка чтения файла в строковый буффер
            try {
                try {
					str = rd.readLine();
					while(str != null){
						buf.append(str);
						buf.append(" ");
						str = rd.readLine();
					}
					buf.deleteCharAt(buf.length()-1);
				} finally {
					rd.close();
				}
            } catch (Exception e) { //секция перехвата исключений
                throw new RuntimeException(e);
            }

        }

        @Override
        public void setFileName(String fullFileName) {
            this.fulFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return buf.toString();
        }
    }
}
