package ch2.s1;

import ch2.s2.Merge;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Example {

    private enum sort {
        SELECTION,
        INSERTION,
        SHELL,
        MERGE
    }

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
//        StdOut.println("Swapping " + i + " with " + j);
    }

    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String sort = args[0];
        String[] a  = StdIn.readAllStrings();

        switch(Example.sort.valueOf(sort.toUpperCase())) {
            case SELECTION:
                Selection.sort(a);
                break;
            case INSERTION:
                Insertion.sort(a);
                break;
            case SHELL:
                Shell.sort(a);
                break;
            case MERGE:
                Merge.sort(a);
                break;
        }

        assert isSorted(a);
        show(a);
    }
}
