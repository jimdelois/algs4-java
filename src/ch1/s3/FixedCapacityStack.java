package ch1.s3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<T> {

    private T[] a;
    private int n;

    public FixedCapacityStack(int capacity) {
        a = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        a[n++] = item;
    }

    public T pop() {
        return a[--n];
    }

    public static void main(String[] args) {

        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(100);

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) {
                stack.push(item);
            }
            else if ( !stack.isEmpty() ) {
                StdOut.print(stack.pop() + " ");
            }
        }

        StdOut.println("(" + stack.size() + ") left on stack");

    }


}
