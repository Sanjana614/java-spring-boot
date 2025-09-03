package org.example.lld.lrucache;

public class DoublyLinkedList<K, V> {
    private final Node<K,V> head;
    private final Node<K,V> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addToFront(Node<K, V> node) {
        node.setNext(head.getNext());
        node.setPrev(head);
        head.getNext().setPrev(node);
        head.setNext(node);
    }

    public void removeFromTail() {
        Node<K, V> lastNode = tail.getPrev();
        deleteNode(lastNode);
    }

    public void shiftToFront(Node<K, V> node) {
        deleteNode(node);
        addToFront(node);
    }

    public void deleteNode(Node<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setPrev(null);
        node.setNext(null);
    }

    public Node<K, V> getLastNode() {
        return this.tail.getPrev();
    }
}
