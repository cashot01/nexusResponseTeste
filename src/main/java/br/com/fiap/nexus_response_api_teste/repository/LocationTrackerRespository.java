package br.com.fiap.nexus_response_api_teste.repository;

import br.com.fiap.nexus_response_api_teste.model.LocationTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTrackerRespository extends JpaRepository<LocationTracker, Long>, JpaSpecificationExecutor<LocationTracker> {
}
