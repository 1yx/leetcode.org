import java.util.*;
/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
class Twitter {

    class Tweet {
        int id;
        int timestamp;
        Tweet next;
        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    Map<Integer, Tweet> twitter;
    Map<Integer, Set<Integer>> followings;
    int timestamp = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp ++;
        if (twitter.containsKey(userId)) {
            Tweet prev = twitter.get(userId);
            Tweet curr = new Tweet(tweetId, timestamp);
            curr.next = prev;
            twitter.put(userId, curr);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
        if (twitter.containsKey(userId)) {
            heap.offer(twitter.get(userId));
        }
        Set<Integer> fo = followings.get(userId);
        if (fo != null && fo.size() > 0) {
            for (int uid: fo) {
                Tweet t = twitter.get(uid);
                if (t != null) heap.offer(t);
            }
        }
        List<Integer> res = new ArrayList<>(10);
        for (int i = 0; !heap.isEmpty() && i < 10; i ++) {
            Tweet t = heap.poll();
            res.add(t.id);
            if (t.next != null)
                heap.offer(t.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        Set<Integer> fo = followings.get(followerId);
        if (fo != null) {
            fo.add(followeeId);
        } else {
            Set<Integer> uids = new HashSet<>();
            uids.add(followeeId);
            followings.put(followerId, uids);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        Set<Integer> fo = followings.get(followerId);
        if (fo != null) {
            fo.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

