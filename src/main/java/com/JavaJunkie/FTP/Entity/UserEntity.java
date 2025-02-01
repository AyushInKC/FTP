package com.JavaJunkie.FTP.Entity;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
@Entity
public class UserEntity {

    private String username;
    private String password;
}
