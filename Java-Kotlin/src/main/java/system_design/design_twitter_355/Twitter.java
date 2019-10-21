package system_design.design_twitter_355;

import java.util.*;
import java.util.stream.Collectors;

//Notice: this class is NOT THREAD SAFE!!!
public class Twitter {

    private static final int FEED_THRESHOLD = 10;

    /**
     * key: user id, value: list of tweet he or she tweets
     */
    private final Map<Integer, List<Tweet>> userTweetMapping;

    /**
     * key: user, value a list of user id the key follows
     */
    private final Map<Integer, Set<Integer>> userFollowerMapping;

    /**
     * Use to distinguish recent and earlier tweet in our system
     */
    private int tweetCounter = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.userTweetMapping = new HashMap<>();
        this.userFollowerMapping = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweetCounter++;
        Tweet tweet = new Tweet(tweetId, tweetCounter);
        if (userTweetMapping.containsKey(userId)) {
            userTweetMapping.get(userId).add(tweet);
        } else {
            List<Tweet> tweets = new ArrayList<>();
            tweets.add(tweet);
            userTweetMapping.put(userId, tweets);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> totalTweets = new ArrayList<>();

        List<Tweet> ownTweets = new ArrayList<>();
        if (userTweetMapping.containsKey(userId)) {
            // find user's own tweets first
            ownTweets = userTweetMapping.get(userId);
        }

        List<Tweet> userFollowersTweets = new ArrayList<>();
        if (userFollowerMapping.containsKey(userId)) {
            Set<Integer> followers = userFollowerMapping.get(userId);
            for (Integer followerId : followers) {
                if (userTweetMapping.containsKey(followerId)) {
                    userFollowersTweets.addAll(userTweetMapping.get(followerId));
                }
            }
        }

        totalTweets.addAll(ownTweets);
        totalTweets.addAll(userFollowersTweets);

        totalTweets.sort(((o1, o2) -> Integer.compare(o2.tweetCounter, o1.tweetCounter));

        if (totalTweets.size() <= FEED_THRESHOLD) {
            return totalTweets.stream().map(tweet -> tweet.tweetId).collect(Collectors.toList());
        } else {
            return totalTweets.subList(0, FEED_THRESHOLD).stream().map(tweet -> tweet.tweetId).collect(Collectors.toList());
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        // a user don't need to follow himself
        if (followeeId == followerId) {
            return;
        }
        if (userFollowerMapping.containsKey(followerId)) {
            userFollowerMapping.get(followerId).add(followeeId);
        } else {
            Set<Integer> followers = new HashSet<>();
            followers.add(followeeId);
            userFollowerMapping.put(followerId, followers);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userFollowerMapping.containsKey(followerId)) {
            Set<Integer> followers = userFollowerMapping.get(followerId);
            followers.remove(followeeId);
        }
    }

    private static class Tweet {
        private int tweetId;
        private int tweetCounter;

        private Tweet(int tweetId, int tweetCounter) {
            this.tweetId = tweetId;
            this.tweetCounter = tweetCounter;
        }

    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1).forEach(feed -> System.out.println(feed));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1).forEach(feed -> System.out.println(feed));
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1).forEach(feed -> System.out.println(feed));
    }
}
