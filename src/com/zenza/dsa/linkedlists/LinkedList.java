package com.zenza.dsa.linkedlists;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    // addFirst
    public void addFirst(int val) {
        var node = new Node(val);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    // addLast
    public void addLast(int item) {

        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

    }

    // contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    // deleteFirst
    public void removeFirst() {

        if(isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        }
        var second = first.next;
        first = null;
        first = second;
    }

    // deleteLast
    public void removeLast() {
        // [10 -> 20 -> 30]
        // previous -> 20
        // last -> 20
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == last) return current;
            current = current.next;
        }

        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
