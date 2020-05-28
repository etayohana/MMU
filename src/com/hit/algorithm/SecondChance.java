

package com.hit.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class SecondChance<K,V> extends  AbstractAlgoCache<K,V> {

    int capacity;

    HashMap<K, V> cache;
    HashMap<K, Integer> Rbit;

    public SecondChance(int capacity) {
        super(capacity);
        this.capacity = capacity;

        cache = new HashMap<K, V>();
        Rbit = new LinkedHashMap<K, Integer>();
    }

    @Override
    public V getElement(K key) {
        V remValue = null;
        if (cache.containsKey(key)) {
            remValue = cache.get(key);
            Rbit.remove(key);
        }
        return remValue;
    }

    @Override
    public V putElement(K key, V value) {
        K remKey;
        V remValue = null;
        if (!cache.containsKey(key)) {
            if (cache.size() == capacity) {
                remKey = findFirstZero();
                remValue = cache.remove(remKey);
                removeElement(remKey);
            }

            cache.put(key, value);
            Rbit.put(key, 0);
        } else
            Rbit.put(key, 1);

        return remValue;
    }

    public void removeElement(K key) {
        if (cache.containsKey(key)) {
            Rbit.remove(key);
            cache.remove(key);
        }
    }

    K findFirstZero() {
        K returnKey = null;
        Set<Entry<K, Integer>> set = Rbit.entrySet();
        Iterator<Entry<K, Integer>> It = set.iterator();
        Iterator<Entry<K, Integer>> It2 = set.iterator();

        while (It.hasNext()) {
            Map.Entry me = (Map.Entry) It.next();
            if ((int) me.getValue() == 0) {
                returnKey = (K) me.getKey();
                return returnKey;
            } else
                me.setValue(0);
        }

        Map.Entry me = (Map.Entry) It2.next();
        returnKey = (K) me.getKey();
        return returnKey;
    }
}
