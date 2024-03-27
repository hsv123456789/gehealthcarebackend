package com.example.gehealthcarebackend.repository;

import com.example.gehealthcarebackend.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token,Integer> {

    @Query("{ 'user.id': ?0, 'loggedOut': false }")
    List<Token> finalAllTokensByUser(String userId);
    Optional<Token> findByToken(String token);


}
