package com.example.gehealthcarebackend.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "token")
public class Token {
    @Id
    private String id;
    private String token;
    private boolean loggedOut;
    @DBRef
    private User user;


}
