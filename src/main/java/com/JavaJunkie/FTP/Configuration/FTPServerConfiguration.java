package com.JavaJunkie.FTP.Configuration;

import jakarta.annotation.PostConstruct;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;

@Component
public class FTPServerConfiguration {

    private FtpServer ftpServer;

    @PostConstruct
    public void startFtpServer() {
        try {

            FtpServerFactory serverFactory = new FtpServerFactory();

            ListenerFactory factory = new ListenerFactory();
            factory.setPort(2121);


            serverFactory.addListener("default", factory.createListener());


            PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
            UserManager userManager = userManagerFactory.createUserManager();

            BaseUser user = new BaseUser();
            user.setName("Ayush");
            user.setPassword("MySecureFTP123");
            File ftpRoot = new File("ftp-root");
            if (!ftpRoot.exists()) {
                ftpRoot.mkdirs();
            }
            user.setHomeDirectory(ftpRoot.getAbsolutePath());
//            user.setHomeDirectory("C:/Users/Samie/FTPStorage");
            user.setAuthorities(Collections.singletonList(new WritePermission()));

            userManager.save(user);
            serverFactory.setUserManager(userManager);

            ftpServer = serverFactory.createServer();
            ftpServer.start();

            System.out.println("FTP Server started on port 2121...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
