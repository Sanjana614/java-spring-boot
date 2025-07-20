package org.example.lld.hashmap;

public interface MyMap<K, V> {

    V get(K key);

    V put(K key, V value);

    V remove(K key);
}
