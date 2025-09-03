package org.example.lld.linkedin;

import org.example.lld.linkedin.entity.Member;
import org.example.lld.linkedin.entity.content.Post;
import org.example.lld.linkedin.enums.ConnectionResponseType;
import org.example.lld.linkedin.service.ConnectionService;
import org.example.lld.linkedin.service.NewsFeedService;
import org.example.lld.linkedin.service.SearchService;
import org.example.lld.linkedin.strategy.ChronologicalSortStrategy;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Linkedin {
    private static Linkedin instance;
    private Map<String, Member> memberMap;
    private final ConnectionService connectionService;
    private final NewsFeedService newsFeedService;
    private final SearchService searchService;

    private Linkedin() {
        this.memberMap = new HashMap<>();
        this.connectionService = new ConnectionService();
        this.newsFeedService = new NewsFeedService();
        this.searchService = new SearchService();
    }

    public static Linkedin getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Linkedin.class) {
                if (Objects.isNull(instance)) {
                    instance = new Linkedin();
                }
            }
        }
        return instance;
    }

    public void registerMember(Member member) {
        memberMap.put(member.getId(), member);
    }

    public String sendConnectionRequest(Member from, Member to) {
        return connectionService.sendConnectionRequest(from, to);
    }

    public void acceptConnectionRequest(String requestId) {
        connectionService.respondConnectionRequest(requestId, ConnectionResponseType.ACCEPT);
    }

    public void createPost(String memberId, String title, String content) {
        newsFeedService.addPost(memberId, new Post(memberMap.get(memberId), title, content));
    }

    public void viewNewsFeed(String memberId) {
        newsFeedService.displayFeedForMember(memberMap.get(memberId), new ChronologicalSortStrategy());
    }

    public Post getLatestPostByMember(String memberId) {
        List<Post> posts = newsFeedService.getMemberPost(memberMap.get(memberId));
        if (CollectionUtils.isEmpty(posts)) {
            System.out.println("No posts to display.");
            return null;
        }
        return posts.get(0);
    }

    public List<Member> searchMemberByName(String text) {
        return searchService.searchMemberByName(memberMap.values(), text);
    }
}
