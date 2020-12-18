package com.jr.level.level40.task4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL(args[0]));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(), 80);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream.println("GET " + url.getPath());

            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
