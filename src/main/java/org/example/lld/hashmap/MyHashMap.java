package org.example.lld.hashmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private final int INITIAL_CAPACITY = 16;

    public static class Entry<K,V> {
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K,V>[] buckets;

    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    @Override
    public V get(K key) {
        int i = hash(key);
        Entry<K, V> entry = buckets[i];
        while(entry != null) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        int i = hash(key);
        Entry<K, V> entry = buckets[i];
        while(entry != null) {
            if (key.equals(entry.key)) {
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }
        Entry<K,V> newEntry = new Entry<>(key, value);
        newEntry.next = buckets[i];
        buckets[i] = newEntry;
        return oldValue;
    }

    @Override
    public V remove(K key) {
        V oldValue = get(key);
        int i = hash(key);
        Entry<K, V> entry = buckets[i];
        while(entry != null) {
            if (key.equals(entry.key)) {
                entry.value = null;
                return oldValue;
            }
            entry = entry.next;
        }
        return oldValue;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() % buckets.length;
    }
}