package com.jr.level.level22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "Ivanov");
//        map.put("country","Ukraine");
//        map.put("city","Kiev");
//        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry: params.entrySet()) {
            if(entry.getKey() == null || entry.getValue() == null) continue;
            sb.append(entry.getKey());
            sb.append(" = '");
            sb.append(entry.getValue());
            sb.append("' and ");
        }
        if(sb.length() > 0)
            sb.delete(sb.length()-5,sb.length());
        return sb.toString();
    }
}
//name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
