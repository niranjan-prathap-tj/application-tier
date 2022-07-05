package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.MessageRepository;


@RestController
@CrossOrigin(origins = "*")
public class DemoController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    WishRepository wishRepository;

   // private String msg = "Hello World!";
    private List<Message> messages = new ArrayList<>();
    private List<Message> wishMessages = new ArrayList<>();
    
    DemoController() {
        messages.add(new Message("Hello world"));
        messages.add(new Message("Hai from spring boot!"));
        messages.add(new Message("hello from backend"));
        wishMessages.add(new Message("Good Morning"));
        wishMessages.add(new Message("Good Afternoon"));
        wishMessages.add(new Message("Good Evening"));
        wishMessages.add(new Message("Good Night"));
    }
   
    @CrossOrigin
    @GetMapping("/api/v1") 
    public List<Message> messages() {
        return messageRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/v2") 
    public List<Wish> wishes() {
        return wishRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/test") 
    public String test() {
        return "Hello World!";
    }

}
