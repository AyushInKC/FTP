package com.JavaJunkie.FTP.Services;

import com.JavaJunkie.FTP.DTO.FileUploadRequestDTO;

import com.JavaJunkie.FTP.Repository.FileRepository;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;

@Component
@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    private static final String FTP_ROOT_DIR = "/ftp-root/";
    private static final String SERVER = "localhost";
    private static final int PORT = 2121;
    public String uploadFile(FileUploadRequestDTO request, MultipartFile file) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(SERVER, PORT);
            if (!ftpClient.login(request.getUsername(), request.getPassword())) {
                return "Invalid credentials!";
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            InputStream inputStream = file.getInputStream();
            boolean uploaded = ftpClient.storeFile(request.getFilename(), inputStream);
            inputStream.close();

            ftpClient.logout();
            ftpClient.disconnect();

            String formattedTime = request.getUploadTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return uploaded
                    ? "File uploaded successfully at " + formattedTime
                    : "File upload failed!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file: " + e.getMessage();
        }
    }
}
