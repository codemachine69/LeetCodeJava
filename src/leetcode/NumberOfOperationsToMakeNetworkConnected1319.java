package leetcode;

public class NumberOfOperationsToMakeNetworkConnected1319 {
    private class DisjointSet {
        private int[] parent;
        private int[] size;
        int numberOfComponents;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            numberOfComponents = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            if (x == parent[x])
                return x;

            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX != parentY) {
                if (size[parentX] > size[parentY]) {
                    parent[parentY] = parentX;
                } else if (size[parentY] > size[parentX]) {
                    parent[parentX] = parentY;
                } else {
                    parent[parentY] = parentX;
                    size[parentX] += 1;
                }
                numberOfComponents--;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) return -1;

        int extraEdges = 0;
        int components = 0;

        DisjointSet ds = new DisjointSet(n);

        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            if (ds.find(u) == ds.find(v)) extraEdges++;
            else ds.union(connection[0], connection[1]);
        }

        return ds.numberOfComponents - 1;
    }
}
