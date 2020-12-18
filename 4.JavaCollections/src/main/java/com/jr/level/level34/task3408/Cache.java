package com.jr.level.level34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K,V>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V value = cache.get(key);
        if(value == null){
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            value = constructor.newInstance(key);
            cache.put(key, value);
        }
        return value;
    }

    public boolean put(V obj) {
        int size = cache.size();
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            cache.put((K) getKey.invoke(obj), obj);
        } catch (Exception e){
        }
        return size < cache.size();
    }

    public int size() {
        return cache.size();
    }
}
