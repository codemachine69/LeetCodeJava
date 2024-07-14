package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite785 {
    boolean bfs(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();


            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color))
                    return false;
            }
        }
        return true;
    }
}
