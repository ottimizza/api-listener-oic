package br.com.ottimizza.oiclistener.domain.mappers;

import org.json.JSONObject;

import br.com.ottimizza.oiclistener.domain.dto.ArquivoProcessadoDTO;
import br.com.ottimizza.oiclistener.domain.dto.ObjetoArquivoProcessado;

public class ArquivoProcessadoMapper {
    
    public static ArquivoProcessadoDTO fromJson(JSONObject message) {
		ArquivoProcessadoDTO dto = new ArquivoProcessadoDTO();
		if (message.has("nomeEmpresa"))				dto.setNomeEmpresa(message.optString("nomeEmpresa"));
		if (message.has("nomeContabilidade"))		dto.setNomeContabilidade(message.optString("nomeContabilidade"));
		if (message.has("codigoERP"))				dto.setCodigoERP(message.optString("codigoERP"));
		if (message.has("tipoMovimento"))	        dto.setTipoMovimento(message.optString("tipoMovimento"));
		if (message.has("nomeArquivo"))			    dto.setNomeArquivo(message.optString("nomeArquivo"));
		return dto;
	}

	public static ObjetoArquivoProcessado objFromJson(JSONObject message) {
		ObjetoArquivoProcessado dto = new ObjetoArquivoProcessado();
		if (message.has("nomeEmpresa"))				dto.setNomeEmpresa(message.optString("nomeEmpresa"));
		if (message.has("nomeContabilidade"))		dto.setNomeContabilidade(message.optString("nomeContabilidade"));
		if (message.has("codigoERP"))				dto.setCodigoERP(message.optString("codigoERP"));
		if (message.has("tipoMovimento"))	        dto.setTipoMovimento(message.optString("tipoMovimento"));
		if (message.has("nomeArquivo"))			    dto.setNomeArquivo(message.optString("nomeArquivo"));
		return dto;
	}

}
