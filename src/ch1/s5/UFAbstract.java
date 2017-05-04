package ch1.s5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

abstract public class UFAbstract implements UF {

    private enum Clazz {
        QUICKFIND
    }

    protected int id[];
    protected int count;

    public UFAbstract(int n) {
        count = n;
        id    = new int[n];
        for(int i = 0; i<n; i++) {
            id[i] = i;
        }
    }

    abstract public void union(int p, int q);


    abstract public int find(int p);

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    static protected UF getUF(int n) {
        return new UFQuickFind(n);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = getUF(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
