package leetcode;

public class NumOfProvinces547 {
    private void dfs(int[][] adj, int node, boolean[] vis) {
        vis[node] = true;
        for (int j = 0; j < adj.length; j++) {
            if (adj[node][j] == 1 && !vis[j]) {
                dfs(adj, j, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int j = 0; j < n; j++) {
            if (!vis[j]) {
                dfs(isConnected, j, vis);
                cnt++;
            }
        }

        return cnt;
    }
}
