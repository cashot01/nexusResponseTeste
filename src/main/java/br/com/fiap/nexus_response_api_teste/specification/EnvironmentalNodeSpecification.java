package br.com.fiap.nexus_response_api_teste.specification;

import br.com.fiap.nexus_response_api_teste.controller.EnvironmentalNodeController;
import br.com.fiap.nexus_response_api_teste.model.EnvironmentalNode;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentalNodeSpecification {

    public static Specification<EnvironmentalNode> withFilters(EnvironmentalNodeController.EnvironmentalNodeFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter == null) return null;

            if (filter.tempDispositivo() != null) {
                predicates.add(cb.equal(root.get("tempDispositivo"), filter.tempDispositivo()));
            }

            if (filter.umidade() != null) {
                predicates.add(cb.equal(root.get("umidade"), filter.umidade()));
            }

            if (filter.nivelAgua() != null) {
                predicates.add(cb.equal(root.get("nivelAgua"), filter.nivelAgua()));
            }

            if (filter.idUsuario() != null) {
                predicates.add(cb.equal(root.get("usuario").get("id"), filter.idUsuario()));
            }

            if (filter.idNivelUrgencia() != null) {
                predicates.add(cb.equal(root.get("nivelUrgencia").get("id"), filter.idNivelUrgencia()));
            }

            if (filter.idStatusAgua() != null) {
                predicates.add(cb.equal(root.get("statusAgua").get("id"), filter.idStatusAgua()));
            }

            if (filter.idLocation() != null) {
                predicates.add(cb.equal(root.get("locationTracker").get("id"), filter.idLocation()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

