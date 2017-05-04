package ch1.s3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagLinkedList<T> implements Iterable<T> {

    private Node head;
    private int n = 0;

    private class Node {
        T    item;
        Node next;
    }

    public void add(T item) {

        Node new_node = new Node();
        new_node.item = item;
        new_node.next = head;

        head = new_node;

        ++n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<T> iterator() {
        return new BagLinkedListIterator();
    }

    private class BagLinkedListIterator implements Iterator<T> {

        private Node cursor = head;

        public boolean hasNext() {
            return (cursor != null);
        }

        public T next() {

            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T item = cursor.item;
            cursor = cursor.next;

            return item;
        }

    }
}
