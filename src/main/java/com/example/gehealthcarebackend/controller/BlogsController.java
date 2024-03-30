package com.example.gehealthcarebackend.controller;


import com.example.gehealthcarebackend.models.Blogs;
import com.example.gehealthcarebackend.repository.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.channels.MulticastChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class BlogsController {
    @Value("${file.upload.dir}")
    private String fileUploadDir;

    private BlogsRepository blogsRepository;
    BlogsController(BlogsRepository blogsRepository){
        this.blogsRepository = blogsRepository;
    }

    @PostMapping("/create-blog")
    public ResponseEntity<?> createABlog(@RequestParam("image") MultipartFile file, @RequestParam("title") String title,
           @RequestParam("description") String description,
           @RequestParam("author") String author,
           @RequestParam("content") String content){
        try{
            String fileName = Long.toString(System.currentTimeMillis()) + "-" + file.getOriginalFilename();
            Path filePath = Paths.get(fileUploadDir + File.separator + fileName);
            Files.write(filePath, file.getBytes());

            Blogs blog = new Blogs();
            blog.setTitle(title);
            blog.setDescription(description);
            blog.setImageUrl(fileName);
            blog.setAuthor(author);
            blog.setContent(content);
            blogsRepository.save(blog);
            return ResponseEntity.ok(blog);
        }
        catch (Exception error){
           return ResponseEntity.status(500).body(error);
        }

    }

    @GetMapping("/get-all-blogs")
    public ResponseEntity<?> getAllBlogs(){
        try{
            List<Blogs> blogs = blogsRepository.findAll();
            return ResponseEntity.ok(blogs);
        }
        catch (Exception error){
         return    ResponseEntity.status(500).body(error);
        }
    }
    @DeleteMapping("/delete-all-blogs")
    public String deleteAllBlogs(){
        try{
            blogsRepository.deleteAll();
            return "All blogs have been deleted successfully";
        }
        catch (Exception error){
            return "Something wrong has happened while deleting blogs";
        }
    }


}
