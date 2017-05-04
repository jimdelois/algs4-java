package ch1.s3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {

    private Bag<Double> bag = new Bag<Double>();

    public static void main(String[] args) {

        Stats stats = new Stats();

        while (!StdIn.isEmpty()) {
            stats.bag.add(StdIn.readDouble());
            StdOut.println("Running Average: " + stats.average() );
        }

    }

    private Double average() {
        double sum = 0;
        for ( Double n : bag ) {
            sum += n;
        }

        return sum / bag.size();
    }
}
