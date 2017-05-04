package ch1.s5;

public class UFQuickFind extends UFAbstract {

    public UFQuickFind(int n) {
        super(n);
    }

    static protected UF getUF(int n) {
        return new UFQuickFind(n);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) { return; }

        for (int i = 0; i < id.length; i++ ) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
}
