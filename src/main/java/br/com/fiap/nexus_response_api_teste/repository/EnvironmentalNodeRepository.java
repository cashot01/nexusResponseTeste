package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.EnvironmentalNode;
import br.com.fiap.nexus_response_api_teste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentalNodeRepository extends JpaRepository<EnvironmentalNode, Long>, JpaSpecificationExecutor<EnvironmentalNode> {

}
