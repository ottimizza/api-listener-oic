package br.com.ottimizza.oiclistener.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.ottimizza.oiclistener.service.ArquivoProcessadoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class KafkaConsumers {

    @Autowired
    public KafkaProperties kafkaProperties;

	@Autowired
	private ArquivoProcessadoService service;
    
    @KafkaListener(topics = "#{kafkaProperties.getPrefix()}ottimizza.oic_processado", 
            	   groupId = "#{kafkaProperties.getPrefix()}tareffa-queue-events-group")
    public void integraArquivo(@Payload String message) throws JsonProcessingException, JsonMappingException {
    	
    	try {
    		service.salvaArquivoProcessado(message);
    	} catch (Exception e) {
    		System.out.println("Error service.salvaArquivo --> "+e.getMessage());
		}

    }
}
