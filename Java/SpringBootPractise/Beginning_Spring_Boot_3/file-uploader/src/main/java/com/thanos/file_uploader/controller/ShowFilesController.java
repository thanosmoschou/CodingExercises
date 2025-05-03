package com.thanos.file_uploader.controller;

import com.thanos.file_uploader.service.ShowAllFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/all")
public class ShowFilesController {
    @Autowired
    private ShowAllFilesService filesService;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("files", filesService.retrieveAllFiles());

        return "all_files_page";
    }
}
