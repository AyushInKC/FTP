package com.JavaJunkie.FTP.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileUploadRequestDTO {
    private String username;
    private String password;
    private String filename;
    private LocalDateTime uploadTime;
}
