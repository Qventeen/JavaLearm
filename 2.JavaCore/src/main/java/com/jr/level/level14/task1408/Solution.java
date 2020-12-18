package com.jr.level.level14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if(RussianHen.country.equals(country))
                hen = new RussianHen();
            else if(UkrainianHen.country.equals(country))
                hen = new UkrainianHen();
            else if(MoldovanHen.country.equals(country))
                hen = new MoldovanHen();
            else if(BelarusianHen.country.equals(country))
                hen = new BelarusianHen();
            return hen;
        }
    }


}
