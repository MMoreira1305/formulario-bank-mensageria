package com.example.mensageria_kafka.controller;

import com.example.mensageria_kafka.dto.ReturnMessageDTO;
import com.example.mensageria_kafka.dto.EmailDTO;
import com.example.mensageria_kafka.messages.producer.EmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send/email")
public class EmailController {

    @Autowired
    private EmailProducer emailProducer;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody EmailDTO sms){
        try {
            emailProducer.sendMessage("email-queue", sms);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ReturnMessageDTO(e.getMessage()));
        }
    }
}
