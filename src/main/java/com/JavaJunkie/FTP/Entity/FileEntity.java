package com.JavaJunkie.FTP.Entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Setter
@Getter
@Document(collection = "files")
@Entity
public class FileEntity {
    @Id
    private String fileId;
    private String filename;
    private String filepath;
    private Long filesize;
    private String uploadedBy;
    private String uploadTime;

}
