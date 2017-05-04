package ch1.s5;

public class UFWeightedQuickUnion extends UFAbstract {

    private int[] sz;

    public UFWeightedQuickUnion(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i<n; i++) {
            sz[i] = 1;
        }
    }

    static protected UF getUF(int n) {
        return new UFWeightedQuickUnion(n);
    }

    public int find(int p) {
        while( p != id[p] ) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        // Make smaller root poing to larger one.
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        --count;
    }
}
