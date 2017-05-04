package ch1.s3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinkedList<T> implements Iterable<T> {

    private Node head;
    private int  n = 0;

    private class Node {
        T    item;
        Node next;
    }

    public void push(T item) {

        Node new_node = new Node();
        new_node.item = item;
        new_node.next = head;

        head = new_node;

        ++n;
    }

    public T pop() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = head.item;
        head   = head.next;
        --n;

        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<T> iterator() {
        return new StackLinkedListIterator();
    }

    private class StackLinkedListIterator implements Iterator<T> {

        Node cursor = head;

        public boolean hasNext() {
            return cursor != null;
        }

        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = cursor.item;
            cursor = cursor.next;

            return item;
        }
    }
}
