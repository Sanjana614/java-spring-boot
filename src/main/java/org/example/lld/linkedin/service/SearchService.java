package org.example.lld.linkedin.service;

import org.example.lld.linkedin.entity.Member;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<Member> searchMemberByName(Collection<Member> members, String text) {
        return members.stream()
                .filter(member -> member.getName().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }
}
