package br.com.fiap.nexus_response_api_teste.repository;


import br.com.fiap.nexus_response_api_teste.model.StatusAgua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatusAguaRepository extends JpaRepository<StatusAgua, Long>, JpaSpecificationExecutor<StatusAgua> {

}
