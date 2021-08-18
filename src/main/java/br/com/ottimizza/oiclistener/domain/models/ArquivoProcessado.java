package br.com.ottimizza.oiclistener.domain.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import br.com.ottimizza.oiclistener.domain.dto.ObjetoArquivoProcessado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "arquivos_processados")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ArquivoProcessado implements Serializable {
    
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "arquivos_sequence", sequenceName = "arquivos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arquivos_sequence")
	private BigInteger id;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private ObjetoArquivoProcessado objetoArquivoProcessado;

    @Column(name = "itegrado_oic")
	private boolean itegradoOic;
    
}
