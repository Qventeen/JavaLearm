package com.jr.level.level35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>(elements.length);
        Collections.addAll(list, elements);
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>();
        Collections.addAll(hashSet, elements);
        return hashSet;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if(keys.size() != values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K,V> hashMap = new HashMap<>();
        Iterator<? extends V> itValue = values.iterator();
        for (K key: keys){
            hashMap.put(key,itValue.next());
        }
        return hashMap;
    }
}
