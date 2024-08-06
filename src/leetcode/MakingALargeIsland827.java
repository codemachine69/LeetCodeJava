package leetcode;

import java.util.HashSet;

public class MakingALargeIsland827 {
    class DisjointSet {
        private int[] parent;
        int[] size;

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

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + drow[k];
                    int nc = j + dcol[k];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                        ds.union(i * n + j, nr * n + nc);
                    }
                }
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Integer> hs = new HashSet<>();
                if (grid[i][j] == 1) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + drow[k];
                    int nc = j + dcol[k];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                        hs.add(ds.find(nr * n + nc));
                    }
                }
                int totalSize = 0;
                for (Integer s : hs) totalSize += ds.size[s];
                max = Math.max(max, totalSize + 1);
            }
        }

        for (int cell = 0; cell < n * n; cell++) {
            max = Math.max(max, ds.size[ds.find(cell)]);
        }

        return max;


    }
}
