package com.JavaJunkie.FTP.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FTPAuthService {

    @Value("${ftp.server.password}")
    private String ftpServerPassword;

    public boolean authenticate(String userEnteredPassword) {
        return ftpServerPassword.equals(userEnteredPassword);
    }
}
