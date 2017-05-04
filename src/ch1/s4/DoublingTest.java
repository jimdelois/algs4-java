package ch1.s4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {

    private enum Algorithm {
        REGULAR,
        FAST
    }

    private static double timeTrial(int n, String test) {

        int MAX = 1000000;
        int a[] = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch timer = new Stopwatch();
        switch(Algorithm.valueOf(test.toUpperCase())) {
            case FAST:
                ThreeSumFast.count(a);
                break;
            case REGULAR:
                ThreeSum.count(a);
                break;
        }
        return timer.elapsed();
    }

    public static void main(String[] args) {
        int start = Integer.parseInt(args[0]);

        double prev = timeTrial(start/2,args[1]);
        for(int i = start; true; i*=2) {
            double time = timeTrial(i,args[1]);
            StdOut.printf("%7d %5.1f", i, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
