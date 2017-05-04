package ch1.s3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int  n = 0;

    private class Node {
        T    item;
        Node next;
    }

    public void enqueue(T item) {

        Node prev_tail = tail;
        tail           = new Node();
        tail.item      = item;

        if (isEmpty()) {
            head = tail;
        } else {
            prev_tail.next = tail;
        }

        ++n;
    }

    public T dequeue() {

        T item = head.item;
        head   = head.next;
        --n;
        if (isEmpty()) {
            tail = null;
        }

        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<T> iterator() {
        return new QueueLinkedListIterator();
    }

    private class QueueLinkedListIterator implements Iterator<T> {

        private Node cursor = head;

        public boolean hasNext() {
            return cursor != null;
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
