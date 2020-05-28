package com.hit.algorithm;
import java.util.ArrayList;
import java.util.List;

public class MRUAlgoCacheImpl<K, V> extends AbstractAlgoCache<K, V> {
    public MRUAlgoCacheImpl(int capacity) {
        super(capacity);
    }

    public V putElement(K key, V value) {
        V valueToReturn = null;
        K currentElement = null;
        if (this.cache.containsKey(key)) {
            valueToReturn = this.getElement(key);
            this.removeElement(key);
        } else if (this.getCapacity() == this.cache.size()) {
            currentElement = this.findKeyToRemove();
            valueToReturn = this.getElement(currentElement);
            this.removeElement(currentElement);
        }

        this.cache.put(key, value);
        return valueToReturn;
    }

    public V getElement(K key) {
        V valueToReturn = null;
        if (this.cache.containsKey(key)) {
            valueToReturn = this.cache.get(key);
        }

        return valueToReturn;
    }

    public void removeElement(K key) {
        if (this.cache.containsKey(key)) {
            this.cache.remove(key);
        }

    }

    private K findKeyToRemove() {
        int KeyLocation = this.cache.size() - 1;
        List<K> list = new ArrayList(this.cache.keySet());
        return list.get(KeyLocation);
    }
}
