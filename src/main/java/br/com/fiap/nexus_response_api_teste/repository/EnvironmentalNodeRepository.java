package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.EnvironmentalNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnvironmentalNodeRepository extends JpaRepository<EnvironmentalNode, Long>, JpaSpecificationExecutor<EnvironmentalNode> {

}
