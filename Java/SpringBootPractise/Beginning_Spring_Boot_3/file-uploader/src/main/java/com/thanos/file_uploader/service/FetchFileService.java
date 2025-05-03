package com.thanos.file_uploader.service;

import com.thanos.file_uploader.model.File;
import com.thanos.file_uploader.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FetchFileService {
    @Autowired
    private FileRepository fileRepository;

    public Resource fetchFile(String filename) throws MalformedURLException {
        File file = fileRepository.findFileByFilename(filename);
        String filepath = file.getFilepath();
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        Resource resource = new UrlResource(path.toUri());

        return resource;
    }
}
