package br.com.ottimizza.oiclistener.service;

import java.math.BigInteger;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public String updateIntegradoOic(List<BigInteger> ids) throws Exception {
		StringBuilder retorno = new StringBuilder();
        try {
			repository.updateIntegradoOic(ids);
            retorno.append("{\"status\":\"Success\",");
            retorno.append("\"message\":\"Item atualizado com sucesso!\"}");
		} catch (Exception e) {
            System.out.println(e.getMessage());
            retorno.append("{\"status\":\"Error\",");
            retorno.append("\"message\":\"Houve um problema ao atualizar!\"}");
			return retorno.toString();
		}
		return retorno.toString();
	}

}
