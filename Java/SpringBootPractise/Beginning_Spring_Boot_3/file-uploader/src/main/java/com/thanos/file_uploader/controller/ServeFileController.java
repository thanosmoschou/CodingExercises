package com.thanos.file_uploader.controller;

import com.thanos.file_uploader.service.FetchFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;

@Controller
@RequestMapping("/files")
public class ServeFileController {
    @Autowired
    private FetchFileService fetchFileService;

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> fetchFile(@PathVariable String filename) throws MalformedURLException {
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(fetchFileService.fetchFile(filename));
    }
}
