package com.jr.level.level19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        System.out.println(IncomeDataAdapter.Formater("(0**)***-**-**","501234567"));

    }

    public static class IncomeDataAdapter implements Customer, Contact  {
        private IncomeData data;
        public static String Formater(String format, String string){
            //символы в форматы просто копируются в результат
            //* заменяются символами входной строки
            StringBuffer sb = new StringBuffer();
            int i = 0;
            for(char ch: format.toCharArray() ){
                if(ch == '*'){
                    if(i < string.length())
                        sb.append(string.charAt(i++));
                    else sb.append(0);
                } else sb.append(ch);
            }
            return sb.toString();
        }

        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuffer sb = new StringBuffer();
            String str =  ((Integer) data.getPhoneNumber()).toString();
           while(str.length() < 10) str = "0".concat(str);
            sb.append('+');
            sb.append(data.getCountryPhoneCode());
            sb.append(Formater("(***)***-**-**",
                    str)
            );
            return sb.toString();
        }
    }



    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JR Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JR Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
