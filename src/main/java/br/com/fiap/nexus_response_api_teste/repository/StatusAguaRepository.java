package br.com.fiap.nexus_response_api_teste.repository;


import br.com.fiap.nexus_response_api_teste.model.StatusAgua;
import br.com.fiap.nexus_response_api_teste.model.TipoStatusAgua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusAguaRepository extends JpaRepository<StatusAgua, Long>, JpaSpecificationExecutor<StatusAgua> {

}
