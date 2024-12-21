package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfKDivisibleComponents2872 {
    private int count = 0;
    private int k;

    private int dfs(int i, boolean[] vis, List<Integer>[] adj, int[] values) {
        vis[i] = true;
        int sum = 0;

        for (int j : adj[i]) {
            if (vis[j]) continue;
            sum += dfs(j, vis, adj, values);
            sum %= k; // Keep the sum within bounds to avoid overflow
        }

        sum += values[i];
        sum %= k; // Add the current node's value and reduce modulo k

        if (sum % k == 0) {
            count++;
            return 0; // Reset sum to 0 as the component is divisible by k
        }

        return sum; // Return the remainder to the parent node
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        this.k = k;
        boolean[] vis = new boolean[n];

        dfs(0, vis, adj, values);

        return count;
    }
}
