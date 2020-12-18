package com.jr.level.level19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;


        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for(Map.Entry<String,String> pair: countries.entrySet()){
                String str = customer.getCountryName();
                if(pair.getValue() == str){
                    return pair.getKey();
                }
            }
            throw new RuntimeException("Некорректное название страны");
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            StringBuffer sb = new StringBuffer("callto://+");
            for(char ch: contact.getPhoneNumber().toCharArray()){
                if(Character.isDigit(ch)){
                   sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JR Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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
