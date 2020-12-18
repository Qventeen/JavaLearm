package com.jr.level.level33.task3310.strategy;

import java.util.Objects;


public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getEntry(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry element = table[index];
        while(element != null){
            if(hash == element.hash && Objects.equals(key, element.key)){
                element.value = value;
                return;
            }
        }
        addEntry(hash,key,value,index);
    }

    @Override
    public Long getKey(String value) {
        Entry res = getEntry(value);
        return res == null? null : res.key;
    }

    @Override
    public String getValue(Long key) {
        Entry res = getEntry(key);
        return res == null? null : res.value;
    }

    //Technical methods
    int hash(Long k){
        return Objects.hashCode(k);
    }

    int indexFor(int hash, int length){
        //Поскольку емкость массива = степени двойки
        return (length - 1) & hash;
    }

    Entry getEntry(Long key){
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry element = table[index];

        while (element != null){
            if(element.hash == hash && Objects.equals(key, element.key)){
                return element;
            }
            element = element.next;
        }
        return null;
    }

    Entry getEntry(String value){
        for(Entry first: table){
            while(first != null){
                if(Objects.equals(value, first.value)){
                    return first;
                }
                first = first.next;
            }
        }
        return null;
    }

    void resize(int newCapacity){
        threshold = (int) (newCapacity * loadFactor);
        Entry[] tab = new Entry[newCapacity];
        transfer(tab);
    }

    void transfer(Entry[] newTable){
        int index;
        int newCapacity = newTable.length;
        Entry next;
        for(Entry element: table){
            while(element != null){
                next = element.next;
                index = indexFor(element.hash, newCapacity);
                element.next = newTable[index];
                newTable[index] = element;
                element = next;
            }
        }
        table = newTable;
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        createEntry(hash, key, value, bucketIndex);
        if(size++ >= threshold){
            resize(table.length << 1);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        table[bucketIndex] = new Entry(hash, key, value, table[bucketIndex]);
    }




}
