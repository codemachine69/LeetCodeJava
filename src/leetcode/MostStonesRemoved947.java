package leetcode;

import java.util.HashSet;

public class MostStonesRemoved947 {
    private class DisjointSet {
        private int[] parent;
        private int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (x == parent[x])
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX != parentY) {
                if (size[parentX] > size[parentY]) {
                    parent[parentY] = parentX;
                    size[parentX] += size[parentY];
                } else {
                    parent[parentX] = parentY;
                    size[parentY] += size[parentX];
                }
            }
        }
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        int n = stones.length;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashSet<Integer> hs = new HashSet<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;

            ds.union(row, col);
            hs.add(row);
            hs.add(col);
        }
        int cnt = 0;
        for (Integer x : hs) {
            if (ds.find(x) == x) cnt++;
        }
        return n - cnt;
    }
}
