package ch2.s1;

public class Shell extends Example {

    final private static int size = 3;

    public static void sort(Comparable[] a) {

        int h = 1;
        while ( h < a.length/size ) {
            h = h * size + 1; // This is considered the "increment sequence"
        }

        while ( h >= 1 ) {
            for ( int i = h; i < a.length; i++ ) {
                // Note the use of "h" where "normal" insertion sort
                // would use "j >= 0 && less(a[j], a[j-1])"
                for ( int j = i; j >= h && less(a[j], a[j-h]); j-= h ) {
                    // same here
                    exchange(a, j, j-h);
                }
            }
            h = h/size; // This is considered the "increment sequence"
        }
    }
}
