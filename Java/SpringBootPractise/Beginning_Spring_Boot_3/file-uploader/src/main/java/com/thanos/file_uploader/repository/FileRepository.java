package com.thanos.file_uploader.repository;

import com.thanos.file_uploader.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    File findFileByFilename(String filename);
}
