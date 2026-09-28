class Tweet {
    int timestamp;
    int id;
    Tweet(int timestamp, int id) {
        this.timestamp = timestamp;
        this.id = id;
    }
}

class Twitter {
    int timestamp = 1;
    HashMap<Integer, List<Tweet>> tweets = new HashMap<>();
    HashMap<Integer, Set<Integer>> following = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(timestamp, tweetId));
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        List<Integer> result = new ArrayList<>();
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        Set<Integer> followees = following.get(userId);
        if (followees != null) {
            users.addAll(followees);
        }
        for (int uid : users) {
            List<Tweet> list = tweets.get(uid);
            if (list != null) {
                Tweet t = list.get(list.size() - 1);
                int[] arr = {t.timestamp, t.id, uid, list.size() - 1};
                maxHeap.offer(arr);
            }
        }
        while (!(maxHeap.isEmpty()) && result.size() < 10) {
            int[] entry = maxHeap.poll();
            result.add(entry[1]);
            if (entry[3] > 0) {
                Tweet older = tweets.get(entry[2]).get(entry[3] - 1);
                maxHeap.offer(new int[]{older.timestamp, older.id, entry[2], entry[3] - 1});
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = following.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
