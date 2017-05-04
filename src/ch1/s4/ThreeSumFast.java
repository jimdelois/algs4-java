package ch1.s4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {

    public static void main(String[] args) {

        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));

    }

    // Count triples that sum to 0
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        for( int i = 0; i < n; i++) {
            for( int j = i+1; j < n; j++) {
                if(BinarySearch.indexOf(a, -a[i]-a[j]) > j) {
                    ++count;
                }
            }
        }

        return count;
    }
}
