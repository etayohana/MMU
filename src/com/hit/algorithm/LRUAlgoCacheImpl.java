package com.hit.algorithm;
import java.util.ArrayList;
import java.util.List;

public class LRUAlgoCacheImpl<K, V> extends AbstractAlgoCache<K, V> {
    public LRUAlgoCacheImpl(int capacity) {
        super(capacity);
    }

    public V putElement(K key, V value) {//return a value if there is no place in the ram else return the one who need to get out
        V valueToReturn = null;
        K currentElement = null;
        if (this.cache.containsKey(key)) {// if this key exsists in the cache
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

    public V getElement(K key) {//if this pge is in the ram, it moving to the start
        V valueToReturn = null;
        if (this.cache.containsKey(key)) {
            valueToReturn = this.cache.get(key);
        }

        return valueToReturn;
    }

    public void removeElement(K key) {//remove the page that needed to be removed from the ram by his key
        if (this.cache.containsKey(key)) {
            this.cache.remove(key);
        }

    }

    private K findKeyToRemove() {
        int KeyLocation = 0;
        List<K> list = new ArrayList(this.cache.keySet());
        return list.get(KeyLocation);
    }
}
