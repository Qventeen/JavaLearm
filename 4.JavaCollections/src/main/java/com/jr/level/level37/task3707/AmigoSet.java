package com.jr.level.level37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;
    private float loadFactor;
    private int capacity;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<E> collection){
        map = new HashMap<>(Math.max(16, (int) (collection.size()/0.75f + 1)));
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> amigoSet = (AmigoSet) super.clone();
            amigoSet.map = (HashMap) map.clone();
            return amigoSet;
        } catch (Exception e){
            throw new InternalError();
        }
    }


    //Deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        //Выполнить стандартную десериализацию
        in.defaultReadObject();
        //Инациализировать HashMap
        map = new HashMap<>(capacity, loadFactor);
        E[] keys = (E[]) in.readObject();
        addAll(Arrays.asList(keys));
    }

    //Serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        //Получить параметры HashMap
        loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");

        //Выполнить стандартную сериализацию
        out.defaultWriteObject();

        //Выполнить дополнительную сериализацию ключей
        out.writeObject(map.keySet().toArray());
    }
}
