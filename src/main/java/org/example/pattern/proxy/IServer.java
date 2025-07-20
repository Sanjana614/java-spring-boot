package org.example.pattern.proxy;

import org.example.pattern.proxy.dto.BrowseResponseDto;

public interface  IServer {
    BrowseResponseDto browseUrl(String url);
}
