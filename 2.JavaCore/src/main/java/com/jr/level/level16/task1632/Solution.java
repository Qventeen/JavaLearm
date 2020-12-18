package com.jr.level.level16.task1632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }

    public static void main(String[] args) {

    }

    public static class Thread1 extends Thread {
        @Override
        public void run(){
            while(true){;}
        }

    }
    public static class Thread2 extends Thread {
        @Override
        public void run(){
            try {
                while(!isInterrupted()){
				;}
				throw new InterruptedException();

            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread {
        @Override
        public void run(){
            try {
                while (true){
					System.out.println("Ура");
                    sleep(500);
				}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while(!isInterrupted()){;}

        }

        @Override
        public void showWarning() {
            if(isAlive())
                interrupt();
        }
    }
    public static class Thread5 extends Thread {
        @Override
        public void run(){
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            try{
                String tmp = rd.readLine();
                int sum = 0;
                while(!"N".equals(tmp)){
                    sum += Integer.parseInt(tmp);
                    tmp = rd.readLine();
                }
                System.out.println(sum);
            }catch (Exception e){

            }
        }
    }

}
