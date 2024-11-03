package com.example.mensageria_kafka.messages.producer;
import com.example.mensageria_kafka.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, EmailDTO message) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            kafkaTemplate.send(topic, mapper.writeValueAsString(message));
        }catch(JsonProcessingException json){
            throw new Exception("Error: Não foi possível transformar mensagem e mandar para a fila de processamento" +
                    ", informações: " + json.getMessage());
        }catch(Exception e){
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
