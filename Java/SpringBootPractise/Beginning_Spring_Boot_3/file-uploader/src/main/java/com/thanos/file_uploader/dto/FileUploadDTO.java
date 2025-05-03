package com.thanos.file_uploader.dto;

import com.thanos.file_uploader.model.FileType;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadDTO {
    private String filename;
    private FileType type;
    private MultipartFile originalFile;

    public FileUploadDTO() {}

    public FileUploadDTO(String filename, MultipartFile originalFile) {
        this.filename = filename;
        this.originalFile = originalFile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public MultipartFile getOriginalFile() {
        return originalFile;
    }

    public void setOriginalFile(MultipartFile originalFile) {
        this.originalFile = originalFile;
    }
}
