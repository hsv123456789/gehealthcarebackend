package com.example.gehealthcarebackend.controller;

import com.example.gehealthcarebackend.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @PostMapping("/")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
    {
        System.out.println(chatMessage);
        return chatMessage;
    }
    @GetMapping
    public String getMessage(){
        return "Hello there";
    }
}
