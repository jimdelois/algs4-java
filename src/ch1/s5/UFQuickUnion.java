package ch1.s5;

public class UFQuickUnion extends UFAbstract {

    public UFQuickUnion(int n) {
        super(n);
    }

    static protected UF getUF(int n) {
        return new UFQuickUnion(n);
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

        if (i == j) return;

        id[i] = j;
        --count;
    }
}
