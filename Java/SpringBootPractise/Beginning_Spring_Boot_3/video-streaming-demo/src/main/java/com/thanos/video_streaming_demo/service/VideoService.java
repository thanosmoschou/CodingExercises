package com.thanos.video_streaming_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VideoService {
    // Search under src/main/resources/video folder
    private final String FORMAT = "classpath:video/%s.mp4";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
        // fromSupplier returns a Mono
        // String.format returns a formatted string using the specified format string and arguments
        return Mono.fromSupplier(() -> this.resourceLoader.getResource(String.format(FORMAT, title)));
    }
}
