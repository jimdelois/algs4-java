package ch1.s4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeSumStopwatchClient {

    public static void main(String[] args) {

        int   n = Integer.parseInt(args[0]);
        int[] a = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = StdRandom.uniform(-1000000,1000000);
        }

        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(a);
        double elapsed = timer.elapsed();

        StdOut.println("Count: " + count + " in " + elapsed + "s");
    }
}
