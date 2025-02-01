package com.JavaJunkie.FTP.Repository;

import com.JavaJunkie.FTP.Entity.FileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<FileEntity, String> {
}
