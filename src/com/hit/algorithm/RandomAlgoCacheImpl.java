package com.hit.algorithm;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAlgoCacheImpl<K, V> extends AbstractAlgoCache<K, V> {
    public RandomAlgoCacheImpl(int capacity) {
        super(capacity);
    }

    public V putElement(K key, V value) {
        V valueToReturn = null;
        K currentElement = null;
        if (this.cache.containsKey(key)) {
            valueToReturn = value;
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
        this.cache.remove(key);
    }

    private K findKeyToRemove() {
      Random rand = new Random();
        int randKeyLocation = rand.nextInt(this.cache.size());
        List<K> list = new ArrayList<>(this.cache.keySet());
        return list.get(randKeyLocation);
    }
}
