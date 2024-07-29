package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops787 {

    private class Triple {
        int stops, node, dist;

        Triple(int stops, int node, int dist) {
            this.stops = stops;
            this.node = node;
            this.dist = dist;
        }
    }

    private class Pair {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Triple> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new Triple(0, src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {
            Triple front = q.poll();
            int stops = front.stops;
            ;
            int node = front.node;
            int d = front.dist;

            if (stops > k) continue;
            for (Pair p : adj.get(node)) {
                int neigh = p.node;
                int price = p.dist;

                if (d + price < dist[neigh]) {
                    dist[neigh] = d + price;
                    q.add(new Triple(stops + 1, neigh, d + price));
                }
            }

        }
        if (dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
