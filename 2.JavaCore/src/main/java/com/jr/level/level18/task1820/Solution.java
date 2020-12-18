package com.jr.level.level18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
             String name1 = rd.readLine();
            String name2 = rd.readLine();
            FileInputStream fin = new FileInputStream(name1);
            FileOutputStream fout = new FileOutputStream(name2);
            try {
                byte[] buf = new byte[fin.available()];
                fin.read(buf);
                String str = new String(buf);
                Integer tmp;
                StringBuffer sb = new StringBuffer();
                for(String s: str.split(" ")) {
					tmp = (int) Math.round(Double.parseDouble(s));
					sb.append(tmp + " ");
				}
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
                fout.write(sb.toString().getBytes());

            } finally {
                rd.close();
                fout.close();
                fin.close();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
//
//            BufferedReader fin = new BufferedReader(new FileReader(name1));
//            BufferedWriter fout = new BufferedWriter(new FileWriter(name2));
//            try {
//                StringBuffer buf = new StringBuffer();
//                while(fin.ready()) {
//                    buf.append(fin.readLine());
//                }
//                Integer tmp;
//                for(String s: buf.toString().split("\\s+")){
//					tmp = (int) (Double.parseDouble(s)+ 0.5);
//					fout.write(tmp.toString() + " ");
//					//System.out.print(tmp.toString() + " ");
//				}
//            } finally {
//                fin.close();
//                fout.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
