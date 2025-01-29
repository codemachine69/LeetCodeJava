public class RedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0] - 1, edge[1] - 1)) return edge;
        }
        return null;
    }

    class DSU {
        private int N;
        private int[] size;
        private int[] parent;

        DSU(int N) {
            this.N = N;
            size = new int[N];
            parent = new int[N];

            for (int i = 0; i < N; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) return false;
            else {
                if (size[a] > size[b]) {
                    parent[b] = a;
                    size[a] += size[b];
                } else {
                    parent[a] = b;
                    size[b] += size[a];
                }
                return true;
            }
        }
    }
}
