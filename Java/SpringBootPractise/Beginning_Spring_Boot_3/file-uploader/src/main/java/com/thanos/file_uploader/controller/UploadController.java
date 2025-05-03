package com.thanos.file_uploader.controller;

import com.thanos.file_uploader.dto.FileUploadDTO;
import com.thanos.file_uploader.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @GetMapping
    public String fetchUploadPage() {
        return "upload";
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String upload(@ModelAttribute FileUploadDTO file) {
        uploadService.storeFile(file);

        return "redirect:/all";
    }

}
