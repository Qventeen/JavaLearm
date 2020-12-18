package com.jr.level.level13.task1301;

/* 
Пиво
*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Drink {
        void askMore(String message);

        void sayThankYou();

        boolean isReadyToGoHome();
    }

    public interface Alcohol extends Drink {
        boolean READY_TO_GO_HOME = false;

        void sleepOnTheFloor();
    }

    public class Beer implements Alcohol {
        @Override
        public void askMore(String massage){}
        @Override
        public void sayThankYou(){}
        @Override
        public boolean isReadyToGoHome(){return READY_TO_GO_HOME;}

        @Override
        public void sleepOnTheFloor(){}
    }
}
