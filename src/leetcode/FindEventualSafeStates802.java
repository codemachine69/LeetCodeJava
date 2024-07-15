package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates802 {
    private boolean dfs(int node, int[][] graph, int[] vis, int[] pathvis, int[] check) {
        vis[node] = 1;
        pathvis[node] = 1;

        for (int neighbor : graph[node]) {
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, graph, vis, pathvis, check)) {
                    return true;
                }
            } else if (pathvis[neighbor] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check = new int[V];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, pathvis, check);
            }
        }

        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}
