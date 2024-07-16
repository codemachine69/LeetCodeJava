package leetcode;

import java.util.ArrayList;

public class CourseSchedule207 {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis) {
        vis[node] = 1;
        pathvis[node] = 1;

        for (Integer n : adj.get(node)) {
            if (vis[n] == 0) {
                if (!dfs(n, adj, vis, pathvis)) {
                    return false;
                }
            } else if (pathvis[n] == 1) {
                return false;
            }
        }

        pathvis[node] = 0;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = prerequisites.length;
        int V = numCourses;
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());


        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (!dfs(i, adj, vis, pathvis)) {
                    return false;
                }
            }
        }

        return true;
    }
}
