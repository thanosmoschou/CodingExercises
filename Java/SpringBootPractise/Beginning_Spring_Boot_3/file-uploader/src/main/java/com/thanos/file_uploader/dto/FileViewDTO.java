package com.thanos.file_uploader.dto;

import com.thanos.file_uploader.model.FileType;

public class FileViewDTO {
    private String filename;
    private String filepath;
    private String streamUrl;
    private FileType type;

    public FileViewDTO() {
    }

    public FileViewDTO(String filename, String streamUrl, FileType type) {
        this.filename = filename;
        this.streamUrl = streamUrl;
        this.type = type;
    }

    public FileViewDTO(String filename, String filepath, String streamUrl, FileType type) {
        this.filename = filename;
        this.filepath = filepath;
        this.streamUrl = streamUrl;
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

}
