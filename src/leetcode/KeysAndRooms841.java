package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n];

        q.add(0);
        vis[0] = 1;

        while (!q.isEmpty()) {
            int front = q.poll();

            for (Integer room : rooms.get(front)) {
                if (vis[room] == 0) {
                    q.add(room);
                    vis[room] = 1;
                }
            }
        }

        for (int x : vis) if (x == 0) return false;
        return true;
    }
}
