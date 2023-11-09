
class Twitter {
    int time = 0;

    Map<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        time++;
        users.get(userId).post(tweetId, time);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)) return new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> b.time-a.time);
        User user = users.get(userId);
        Tweet t = user.tweetHead;
        if(t != null){
            maxHeap.add(t);
        }
        for(int i : user.following){
            User u = users.get(i);
            Tweet ut = u.tweetHead;
            if(ut!=null){
                maxHeap.add(ut);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0;(i<10 && !maxHeap.isEmpty());i++){
            Tweet tt = maxHeap.poll();
            if(tt.next != null)maxHeap.add(tt.next);
            result.add(tt.tweetId);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        if(!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        users.get(followerId).following.remove(followeeId);
    }
}

class Tweet{
    int tweetId;
    int time;
    Tweet next;

    public Tweet(int tweetId){
        this.tweetId = tweetId;
    }
}

class User{
    int userId;
    Tweet tweetHead;

    Set<Integer> following;

    public User(int userId){
        this.userId = userId;
        following = new HashSet<>();
    }

    public void post(int tweetId, int time){
        Tweet t = new Tweet(tweetId);
        t.time = time;
        t.next = tweetHead;
        tweetHead = t;
    }
}