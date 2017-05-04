package ch1.s3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Stack<T> {

    private T[] items;
    private int  n = 0;
    private int size = 1;

    public ResizingArrayStack() {
        items = (T[]) new Object[size];
    }

    public void push(T item) {
        if (n+1 > size) {
            resize(size*2);
        }
        items[n++] = item;
    }

    public T pop() {
        T item = items[--n];
        items[n] = null;

        if (n > 0 && n <= items.length/4) {
            resize(items.length/2);
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
        return new StackArrayIterator();
    }

    private class StackArrayIterator implements Iterator<T> {

        int cursor = 0;

        public boolean hasNext() {
            return cursor != n;
        }

        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return items[cursor++];
        }
    }

    private void resize(int length) {
        T[] resized = (T[]) new Object[length];
        System.out.println("Resizing from " + size + " to " + length);
        for(int i = 0; i < n; i++) {
            resized[i] = items[i];
        }
        size = length;
        items = resized;
    }
}
