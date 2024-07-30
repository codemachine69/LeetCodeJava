package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int n = graph.length;
        dfs(0, graph, res, new ArrayList<>(), n);
        return res;
    }

    private void dfs(int node, int[][] graph, List<List<Integer>> res, List<Integer> curPath, int n) {
        curPath.add(node);
        if (node == n - 1) {
            res.add(new ArrayList<>(curPath));
            curPath.removeLast();
            return;
        }
        for (int neigh : graph[node]) {
            dfs(neigh, graph, res, curPath, n);
        }
        curPath.removeLast();
    }
}
