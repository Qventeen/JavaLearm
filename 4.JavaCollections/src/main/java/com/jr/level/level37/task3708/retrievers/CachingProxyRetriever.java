package com.jr.level.level37.task3708.retrievers;

import com.jr.level.level37.task3708.cache.LRUCache;
import com.jr.level.level37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache<Long, Object> cache = new LRUCache<>(10);
    private OriginalRetriever retriever;


    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
    }


    @Override
    public Object retrieve(long id) {
        Object result = cache.find(id);
        if(result == null){
            result = retriever.retrieve(id);
            cache.set(id, result);
        }
        return result;
    }
}
