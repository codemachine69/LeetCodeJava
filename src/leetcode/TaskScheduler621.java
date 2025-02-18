package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new LinkedList<>();
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        for (int f : freq) if (f > 0) pq.add(f);
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int top = pq.poll() - 1;
                if (top > 0) q.add(new Pair(top, time + n));
            }

            if (!q.isEmpty() && q.peek().time == time) {
                pq.add(q.poll().cnt);
            }
        }

        return time;
    }

    static class Pair {
        int cnt, time;

        Pair(int cnt, int time) {
            this.cnt = cnt;
            this.time = time;
        }
    }
}
