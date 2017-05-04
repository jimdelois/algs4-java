package ch2.s2;

import ch2.s1.Example;

public class Merge extends Example {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {

        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {

        // Exit condition.
        if (hi <= lo) { return; }

        int mid = lo + (hi-lo)/2;

        // Sort left
        sort(a, lo, mid);

        // Sort right
        sort(a, mid+1, hi);

        // Merge
        merge(a, lo, mid, hi);

    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        // Merge a[lo...mid] with a[mid+1...hi]

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Note that CORMEN advises the use of "Sentinels" in the array to mark exhaustion.
        // I should try that approach elsewhere.

        for (int k = lo; k <= hi; k++) {

            // If left half exhausted, pull next from right
            if (i > mid) { a[k] = aux[j++]; }

            // If right half exhausted, pull next from left
            else if (j > hi) { a[k] = aux[i++]; }

            // If right < left, pull from right
            else if (less(aux[j], aux[i])) { a[k] = aux[j++]; }

            // Otherwise, left < right (implies less(aux[i], aux[j]) == true)
            else { a[k] = aux[i++]; }
        }


    }
}
