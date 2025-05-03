package com.thanos.file_uploader.service;

import com.thanos.file_uploader.dto.FileUploadDTO;
import com.thanos.file_uploader.model.FileType;
import com.thanos.file_uploader.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class UploadService {
    @Autowired
    private FileRepository fileRepository;

    private final String folderPath = "uploads";
    private File uploadDir;

    public UploadService() {
        uploadDir = new File(folderPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    public boolean storeFile(FileUploadDTO fileDTO) {
        if (!(fileDTO == null)) {
            String originalFilename = fileDTO.getOriginalFile().getOriginalFilename(); // Original filename of the multipart file
            String savedFilename = fileDTO.getFilename(); // Name that user mentioned on the field

            try {
                com.thanos.file_uploader.model.File savedFile = new com.thanos.file_uploader.model.File();

                if (originalFilename.endsWith(".mp3")) {
                    savedFilename = savedFilename + ".mp3";
                    savedFile.setType(FileType.MP3);
                } else if (originalFilename.endsWith(".txt")) {
                    savedFilename = savedFilename + ".txt";
                    savedFile.setType(FileType.TXT);
                } else if (originalFilename.endsWith(".jpeg")) {
                    savedFilename = savedFilename + ".jpeg";
                    savedFile.setType(FileType.JPEG);
                } else if (originalFilename.endsWith(".jpg")) {
                    savedFile.setType(FileType.JPG);
                } else if (originalFilename.endsWith(".png")) {
                    savedFilename = savedFilename + ".png";
                    savedFile.setType(FileType.PNG);
                } else if (originalFilename.endsWith(".pdf")) {
                    savedFilename = savedFilename + ".pdf";
                    savedFile.setType(FileType.PDF);
                } else {
                    savedFile.setType(FileType.UNKNOWN);
                }

                savedFile.setFilename(savedFilename);
                savedFile.setFilepath(folderPath + "/" + savedFilename);

                byte[] bytes = fileDTO.getOriginalFile().getBytes();
                File f = new File(uploadDir, savedFilename);
                Files.write(f.toPath(), bytes);

                fileRepository.save(savedFile);
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


}
