package br.com.ottimizza.oiclistener.service;

import java.math.BigInteger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ottimizza.oiclistener.domain.dto.ObjetoArquivoProcessado;
import br.com.ottimizza.oiclistener.domain.models.ArquivoProcessado;
import br.com.ottimizza.oiclistener.repositories.ArquivoProcessadoRepository;
import br.com.ottimizza.oiclistener.utils.MessageUtils;

@Service
public class ArquivoProcessadoService {

    @Autowired
    ArquivoProcessadoRepository repository;
    
    public void salvaArquivoProcessado(String message) throws Exception {
        try {
            ObjetoArquivoProcessado obj = MessageUtils.entityFromMessage(message);
            ArquivoProcessado arquivo = ArquivoProcessado.builder()
                                        .objetoArquivoProcessado(obj)
                                        .integradoOic(false)
                                    .build();
            repository.save(arquivo);
        }
        catch(Exception ex) {
            System.out.println("Error save arquivo --> " + ex.getMessage());
        }
    }
    
    public JSONObject updateIntegradoOic(BigInteger id) throws Exception {
		JSONObject response = new JSONObject();
		try {
			repository.updateIntegradoOic(id);
			response.put("status", "Success");
			response.put("message", "Itens atualizados com sucesso!");
		} catch (Exception e) {
			response.put("status", "Error");
			response.put("message", "Houve um problema ao atualizar!");
			return response;
		}
		return response;
	}

}
