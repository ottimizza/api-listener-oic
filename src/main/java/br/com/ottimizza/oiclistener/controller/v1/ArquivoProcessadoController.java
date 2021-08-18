package br.com.ottimizza.oiclistener.controller.v1;

import java.math.BigInteger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ottimizza.oiclistener.service.ArquivoProcessadoService;

@RestController
@RequestMapping("/api/v1/arquivos_processados")
public class ArquivoProcessadoController {

    @Autowired
    ArquivoProcessadoService service;

    @PostMapping("/integra_oic/{arquivoId}")
    public ResponseEntity<?> updateIntegradoOic(@PathVariable BigInteger arquivoId) throws Exception {
        JSONObject response = service.updateIntegradoOic(arquivoId);
		return (response.get("status") == "Success") ? ResponseEntity.ok(response.toString()) : ResponseEntity.badRequest().build();
    }

}
