package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination1976 {

    private static class Pair {
        long weight;
        int node;

        Pair(long weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[2], road[1]));
            adj.get(road[1]).add(new Pair(road[2], road[0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (int) (x.weight - y.weight));
        long[] ways = new long[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int mod = (int) (1e9 + 7);

        ways[0] = 1;
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            long weight = pq.peek().weight;
            int node = pq.peek().node;
            pq.poll();

            for (Pair p : adj.get(node)) {
                int neigh = p.node;
                long neighWeight = p.weight;

                if (weight + neighWeight < dist[neigh]) {
                    dist[neigh] = weight + neighWeight;
                    ways[neigh] = ways[node] % mod;
                    pq.add(new Pair(weight + neighWeight, neigh));
                } else if (weight + neighWeight == dist[neigh]) {
                    ways[neigh] = (ways[neigh] + ways[node]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);
    }
}
