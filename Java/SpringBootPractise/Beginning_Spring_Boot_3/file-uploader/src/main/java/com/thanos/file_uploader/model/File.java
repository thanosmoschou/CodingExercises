package com.thanos.file_uploader.model;

import jakarta.persistence.*;

// Do not store the original file in the db. Only store metadata

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long file_id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private FileType type;

    public File() {

    }

    public File(String filename, String filepath, FileType type) {
        this.filename = filename;
        this.filepath = filepath;
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

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }
}
