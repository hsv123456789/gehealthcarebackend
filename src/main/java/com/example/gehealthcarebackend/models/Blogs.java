package com.example.gehealthcarebackend.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Blogs")
@Data
@NoArgsConstructor
public class Blogs {
    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private String author;
    private String content;
}
