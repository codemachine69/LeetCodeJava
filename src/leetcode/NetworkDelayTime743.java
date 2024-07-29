package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkDelayTime743 {
    private static class Pair {
        int node, time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] time : times) adj.get(time[0]).add(new Pair(time[1], time[2]));
        Queue<Pair> q = new LinkedList<>();
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        q.add(new Pair(k, 0));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int time = q.peek().time;
            q.poll();

            for (Pair p : adj.get(node)) {
                int neighborNode = p.node;
                int neighborTime = p.time;

                if (time + neighborTime < dist[neighborNode]) {
                    dist[neighborNode] = time + neighborTime;
                    q.add(new Pair(neighborNode, time + neighborTime));
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) if (dist[i] > maxVal) maxVal = dist[i];
        if (maxVal == Integer.MAX_VALUE) return -1;
        return maxVal;
    }
}
