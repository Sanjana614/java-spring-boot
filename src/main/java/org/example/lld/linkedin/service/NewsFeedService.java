package org.example.lld.linkedin.service;

import org.example.lld.linkedin.entity.Member;
import org.example.lld.linkedin.entity.content.NewsFeed;
import org.example.lld.linkedin.entity.content.Post;
import org.example.lld.linkedin.strategy.ChronologicalSortStrategy;
import org.example.lld.linkedin.strategy.FeedSortingStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class NewsFeedService {
    private final Map<String, List<Post>> userPostsMap;

    public NewsFeedService() {
        this.userPostsMap = new HashMap<>();
    }

    public void addPost(String memberId, Post post) {
        if (!userPostsMap.containsKey(memberId)) {
            userPostsMap.put(memberId, new ArrayList<>());
        }
        userPostsMap.get(memberId).add(post);
    }

    public List<Post> getMemberPost(Member member) {
        return userPostsMap.getOrDefault(member.getId(), Collections.emptyList());
    }

    public void displayFeedForMember(Member member, FeedSortingStrategy feedSortingStrategy) {
        List<Member> connections = member.getConnections();
        List<Post> posts = connections.stream()
                .filter(m -> Objects.nonNull(userPostsMap.get(m.getId())))
                .map(m -> userPostsMap.get(m.getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        NewsFeed newsFeed = new NewsFeed(posts);
        newsFeed.display(feedSortingStrategy);
    }
}
