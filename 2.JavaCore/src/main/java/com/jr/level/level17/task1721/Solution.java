package com.jr.level.level17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name1 = rd.readLine();
        String name2 = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(name1));
        allLines = fileReader(rd);
        rd.close();

        rd = new BufferedReader(new FileReader(name2));
        forRemoveLines = fileReader(rd);
        rd.close();

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e){
            e.printStackTrace();
        }


    }

    public void joinData () throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
    private static List<String> fileReader(BufferedReader buf) throws IOException{
        List<String> list = new LinkedList<>();
        String tmp = buf.readLine();
        while(tmp != null){
            list.add(tmp);
            tmp = buf.readLine();
        }
        return list;
    }
}
