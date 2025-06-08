package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.NivelUrgencia;
import br.com.fiap.nexus_response_api_teste.model.TipoNivelUrgencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NivelUrgenciaRepository extends JpaRepository<NivelUrgencia, Long>, JpaSpecificationExecutor<NivelUrgencia> {
    Optional<NivelUrgencia> findByDescricaoNivel(TipoNivelUrgencia descricaoNivel);
}
