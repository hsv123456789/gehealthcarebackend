package com.example.gehealthcarebackend.repository;

import com.example.gehealthcarebackend.models.Blogs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends MongoRepository<Blogs,String> {

}
