package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);

            for(int n : adj.get(front)) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    q.add(n);
                }
            }
        }

        if(ans.size() != numCourses) return new int[0];
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
