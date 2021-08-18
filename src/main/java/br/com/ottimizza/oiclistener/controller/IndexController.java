package br.com.ottimizza.oiclistener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    @GetMapping
	@RequestMapping("/")
    public String getIndex() {
        return "{\"api\":\"Api-OicArquivo(listner) is on!\", \"by\":\"Ottimizza\"}";
    }

}
