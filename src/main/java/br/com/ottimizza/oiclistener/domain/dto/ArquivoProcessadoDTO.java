package br.com.ottimizza.oiclistener.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoProcessadoDTO implements Serializable {

    private String nomeEmpresa;

    private String nomeContabilidade;

    private String codigoERP;

    private String tipoMovimento;

    private String nomeArquivo;
}
