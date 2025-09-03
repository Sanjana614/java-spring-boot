package org.example.lld.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache<K,V> {
    private final int capacity;
    private int currentSize;
    private final DoublyLinkedList<K,V> doublyLinkedList;
    private final Map<K, Node<K,V>> lookup;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than Zero.");
        }
        this.capacity = capacity;
        this.currentSize = 0;
        this.lookup = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public synchronized V get(K key) {
        Node<K, V> node = lookup.get(key);
        if (Objects.isNull(node)) {
            return null;
        }
        doublyLinkedList.shiftToFront(node);
        return node.getValue();
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = lookup.get(key);
        if (Objects.nonNull(node)) {
            node.setValue(value);
            doublyLinkedList.shiftToFront(node);
            return;
        }
        if (currentSize == capacity) {
            Node<K, V> tail = doublyLinkedList.getLastNode();
            lookup.remove(tail.getKey());
            doublyLinkedList.removeFromTail();
            currentSize--;
        }
        Node<K, V> newNode = new Node<>(key, value);
        lookup.put(key, newNode);
        doublyLinkedList.addToFront(newNode);
        currentSize++;
    }
}
