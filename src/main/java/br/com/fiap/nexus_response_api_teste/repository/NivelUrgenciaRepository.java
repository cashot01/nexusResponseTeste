package br.com.fiap.nexus_response_api_teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NivelUrgenciaRepository extends JpaRepository<br.com.fiap.nexus_response_api_teste.model.NivelUrgencia, Long>, JpaSpecificationExecutor<br.com.fiap.nexus_response_api_teste.model.NivelUrgencia> {

}
