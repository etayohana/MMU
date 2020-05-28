package com.hit.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractAlgoCache<K, V> implements IalgoCache<K, V> {
    private int capacity;
    protected Map<K, V> cache;

    public AbstractAlgoCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap();
    }

    public int getCapacity() {
        return this.capacity;
    }
}
