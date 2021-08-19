package br.com.ottimizza.oiclistener.utils;

import org.json.JSONObject;

import br.com.ottimizza.oiclistener.domain.dto.ObjetoArquivoProcessado;
import br.com.ottimizza.oiclistener.domain.mappers.ArquivoProcessadoMapper;

public class MessageUtils {
    
    public static String CleanMessage(String message) {
		return message.replaceAll("\\\\", "").replace("\"{","{").replace("}\"","}").trim();
	}

    public static ObjetoArquivoProcessado entityFromMessage(String message) {
		ObjetoArquivoProcessado arquivo = new ObjetoArquivoProcessado();
        String objArquivo = "";
		message = CleanMessage(message);
		System.out.println(message);
		if(message.contains("message")) {
			String s = message.substring(message.indexOf("message"));
            if(s.contains("{") && s.contains("}")) {
                objArquivo = s.substring(s.indexOf("{"), s.indexOf("}")).trim();
            }
            arquivo = ArquivoProcessadoMapper.objFromJson(new JSONObject(objArquivo.trim()));
		}
		return arquivo;
	}
}
