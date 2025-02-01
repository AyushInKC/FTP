package com.JavaJunkie.FTP.Controller;
import com.JavaJunkie.FTP.DTO.FileUploadRequestDTO;
import com.JavaJunkie.FTP.Repository.FileRepository;
import com.JavaJunkie.FTP.Services.FTPAuthService;
import com.JavaJunkie.FTP.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/file/")
public class FileController {
     @Autowired
     private FileService fileService;

     @Autowired
     private FileRepository fileRepository;



    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("username") String username,
                                             @RequestParam("password") String password,
                                             @RequestParam("filename") String filename){
        FileUploadRequestDTO fileUploadRequestDTO = new FileUploadRequestDTO();
        fileUploadRequestDTO.setUsername(username);
        fileUploadRequestDTO.setPassword(password);
        fileUploadRequestDTO.setFilename(filename);
        fileUploadRequestDTO.setUploadTime(LocalDateTime.now());
        String result = fileService.uploadFile(fileUploadRequestDTO, file);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/downloadFile/{filename}")
    public void downloadFile(){

    }

}
