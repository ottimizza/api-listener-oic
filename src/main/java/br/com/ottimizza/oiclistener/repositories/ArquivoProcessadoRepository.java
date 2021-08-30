package br.com.ottimizza.oiclistener.repositories;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.oiclistener.domain.models.ArquivoProcessado;
import feign.Param;

@Repository
public interface ArquivoProcessadoRepository extends JpaRepository<ArquivoProcessado, String>{

    @Modifying
	@Transactional
	@Query(value = "UPDATE arquivos_processados ap SET integrado_oic = true WHERE ap.id IN :arquivosIds ",nativeQuery = true)
	void updateIntegradoOic(@Param("arquivosIds") List<BigInteger> arquivosIds) throws Exception;

}
