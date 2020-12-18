package com.jr.level.level33.task3310.strategy;

import java.util.Objects;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private long maxBucketSize;
    private int size;


    @Override
    public boolean containsKey(Long key) {
        return Objects.nonNull(getEntry(key));
    }

    @Override
    public boolean containsValue(String value) {
        return Objects.nonNull(getEntry(value));
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        FileBucket bucket = table[index];
        //Вычитать цепочку записей из корзины
        if (bucket != null) {
            Entry first = bucket.getEntry();
            //Создать элемент-итератор
            Entry element = first;
            while (element != null) {
                //Если искомый ключ уже существует
                if (element.hash == hash && Objects.equals(key, element.key)) {
                    //Присвоить новой значение
                    element.value = value;
                    //Выполнить перезапись корзины начиная с начала цепочки
                    bucket.putEntry(first);
                    return;
                }
                element = element.next;
            }
        }

        //Если же ранее значений по такому ключи не было добавляем новую запись
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        Entry element = getEntry(value);
        return (element == null)? null : element.key;
    }

    @Override
    public String getValue(Long key) {
        Entry element = getEntry(key);
        return element == null? null : element.value;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        if(bucketSizeLimit >= 2500) {
            this.bucketSizeLimit = bucketSizeLimit;
        }
    }


    //Technical methods as backend for StorageStrategy

    /**
     * Get hash from key
     * @param key
     * @return hashCode for key
     */
    private int hash(Long key){
        return Objects.hashCode(key);
    }

    /**
     * Get index for FileBucket table from hash
     * @param hash base for take of index
     * @param length curren number of elements of FileBucket table
     * @return index for current hash
     */
    private int indexFor(int hash, int length){
        return (length - 1 ) & hash;
    }

    /**
     * Get entry from key
     * @param key
     * @return entry or null (if entry not found)
     */
    private Entry getEntry(Long key){
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry element = table[index].getEntry();
        while(element != null){
            if(hash == element.hash && Objects.equals(key, element.key)){
                return element;
            }
            element = element.next;
        }
        return null;
    }

    /**
     * Get entry from value
     * @param value
     * @return entry or null (if value not found)
     */
    private Entry getEntry(String value){
        for(FileBucket bucket: table){
            if(bucket != null){
                Entry element = bucket.getEntry();
                while(element != null){
                    if(Objects.equals(value, element.value)){
                        return element;
                    }
                    element = element.next;
                }
            }
        }
        return null;
    }

    /**
     * Add new Entry to table of buckets and if maxBucketSize >= bucketSizeLimit
     * resize table
     * @param hash number >= 0
     * @param key  immutable object for identification of entry in table
     * @param value not null value for storage
     * @param indexOfBucket point for storage this entry in table
     */
    private void addEntry(int hash, Long key, String value, int indexOfBucket){
        createEntry(hash, key, value, indexOfBucket);
        size++;
        if (maxBucketSize > bucketSizeLimit){
            resize(table.length << 1);
        }
    }

    /**
     * Creating entry to index of FileBucket table.
     * Control of maxBucketCount field when creates new element.
     * @param hash number >= 0
     * @param key immutable object for identification of entry in table
     * @param value not null value for storage
     * @param indexOfBucket point for storage this entry in table
     */
    private void createEntry(int hash, Long key, String value, int indexOfBucket){
        Entry oldElement = null;
        FileBucket bucket = table[indexOfBucket];
        //Если по данному индексу есть корзина
        if (bucket != null){
            //Достаем из корзины старые записи
            oldElement = bucket.getEntry();
        } else {
            //Создаем новую корзину
            bucket =  new FileBucket();
        }

        //Наполняем корзину новой цепочкой записей
        bucket.putEntry(new Entry(hash, key, value, oldElement));

        //Тест размера корзины
        maxBucketSize = Math.max(maxBucketSize, bucket.getFileSize());

        //Корзина становится частью таблицы
        table[indexOfBucket] = bucket;
    }

    /**
     * Resize table to new capacity
     * @param newCapacity == table.length << 1
     */
    private void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
    }

    /**
     * Transfer old table to new table
     * @param newTable != null and newTable.length > table.length
     */
    private void transfer(FileBucket [] newTable){
        //Заменить старую таблицу новой
        FileBucket[] oldTable = table;
        table = newTable;

        //Обнулить счетчик корзин
        maxBucketSize = 0;

        //Подготовить локальные переменные для работы
        int index;
        int newCapacity = table.length;
        Entry element = null;
        Entry next = null;

        //Выполнить обход всех корзин старой таблицы
        for(FileBucket bucket: oldTable){
            //Вычитать из корзины записи
            element = bucket.getEntry();

            //Удалить файлы принадлежащие корзине
            bucket.remove();

            //Пройти по цепочки элементов
            while(element != null){
                //Вычислить новый индекс по хешу
                index = indexFor(element.hash, newCapacity);

                //Вставить текущий элемент в новую таблицу
                createEntry(element.hash, element.key, element.value, index);

                //Перейти к следующему элементу цепочки
                element = element.next;
            }
        }
    }
}
