package org.example.lld.linkedin.entity.content;

import org.example.lld.linkedin.strategy.FeedSortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed {
    private final List<Post> posts;

    public NewsFeed() {
        this.posts = new ArrayList<>();
    }

    public NewsFeed(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    @Override
    public String toString() {
        return "NewsFeed{" +
                "posts=" + posts +
                '}';
    }

    public void display(FeedSortingStrategy feedSortingStrategy) {
        List<Post> sortedPost = feedSortingStrategy.sort(posts);
        sortedPost.forEach(System.out::println);
    }
}
