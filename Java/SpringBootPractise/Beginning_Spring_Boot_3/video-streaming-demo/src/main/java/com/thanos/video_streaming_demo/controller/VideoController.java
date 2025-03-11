package com.thanos.video_streaming_demo.controller;

import com.thanos.video_streaming_demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping(value = "/video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader(value = "Range", required = false) String range) {
        // Let's print the range header
        // The header format is:
        // Range: bytes=<value1>-<value2>
        // Or
        // Range: bytes=<value1>-
        System.out.println(range);
        return videoService.getVideo(title);
    }
}
