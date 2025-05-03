package com.thanos.file_uploader.service;

import com.thanos.file_uploader.dto.FileViewDTO;
import com.thanos.file_uploader.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAllFilesService {
    @Autowired
    private FileRepository fileRepository;

    public List<FileViewDTO> retrieveAllFiles() {
        return fileRepository.findAll().stream()
                .map(file -> new FileViewDTO(
                        file.getFilename(),
                        file.getFilepath(),
                        "/files/" + file.getFilename(),
                        file.getType())
                ).toList();
    }
}
