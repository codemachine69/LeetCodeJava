package leetcode;

import java.util.*;

public class DesignTwitter355 {
    HashMap<Integer, HashSet<Integer>> followers;
    HashMap<Integer, HashSet<Tweet>> tweets;
    int gtime;

    public DesignTwitter355() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        gtime = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!followers.containsKey(userId)) {
            HashSet<Integer> s = new HashSet<>();
            s.add(userId);
            followers.put(userId, s);
        }

        if (!tweets.containsKey(userId)) {
            HashSet<Tweet> s = new HashSet<>();
            tweets.put(userId, s);
        }
        tweets.get(userId).add(new Tweet(tweetId, gtime));
        gtime++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (!followers.containsKey(userId)) return res;
        for (int fId : followers.get(userId)) {
            if (!tweets.containsKey(fId)) continue;
            for (Tweet t : tweets.get(fId)) {
                pq.add(t);
            }
        }
        int cnt = 0;
        while (cnt < 10) {
            Tweet top = pq.poll();
            if (top == null) break;
            res.add(top.tid);
            cnt++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!tweets.containsKey(followerId)) {
            HashSet<Tweet> s = new HashSet<>();
            tweets.put(followerId, s);
        }

        if (!followers.containsKey(followerId)) {
            HashSet<Integer> s = new HashSet<>();
            s.add(followerId);
            followers.put(followerId, s);
        }

        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) return;
        followers.get(followerId).remove(followeeId);
    }

    static class Tweet {
        int tid;
        int time;

        Tweet(int tid, int time) {
            this.tid = tid;
            this.time = time;
        }
    }
}
