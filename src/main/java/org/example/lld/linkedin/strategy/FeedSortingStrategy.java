package org.example.lld.linkedin.strategy;

import org.example.lld.linkedin.entity.content.Post;

import java.util.List;

public interface FeedSortingStrategy {

    List<Post> sort(List<Post> posts);
}
