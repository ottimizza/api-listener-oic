package br.com.ottimizza.oiclistener.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
public class ObjetoArquivoProcessado implements Serializable {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeEmpresa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeContabilidade;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigoERP;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tipoMovimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomeArquivo;
}
