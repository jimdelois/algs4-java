package ch1.s3;

public interface Stack<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    T pop();

    void push(T item);

}
