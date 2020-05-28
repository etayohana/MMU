package com.hit.algorithm;
public interface IalgoCache<K, V> {
    V getElement(K var1);

    V putElement(K var1, V var2);

    void removeElement(K var1);
}

