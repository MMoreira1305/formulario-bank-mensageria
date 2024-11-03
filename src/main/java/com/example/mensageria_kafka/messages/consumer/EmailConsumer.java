package com.example.mensageria_kafka.messages.consumer;

import com.example.mensageria_kafka.dto.EmailDTO;
import com.example.mensageria_kafka.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "email-queue", groupId = "my-group-id")
    public void listen(String message) throws Exception {
        EmailDTO emailDTO = null;
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Mensagem - " + message);
        try{
            emailDTO = mapper.readValue(message, EmailDTO.class);
            this.sendMail(emailDTO);
        }catch (Exception e){
            throw new Exception("Error ao enviar email: " + e.getMessage());
        }
    }

    private void sendMail(EmailDTO emailDTO){
        emailService.sendSimpleEmail(emailDTO.email(), "Envio de TOKEN",
                emailDTO.message() + " " + emailDTO.token());
    }
}
