package br.com.fiap.nexus_response_api_teste.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_NEXUS_NIVEL_URGENCIA")
public class NivelUrgencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_urgencia")
    private Long idNivelUrgencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "descricao_nivel", nullable = false, length = 50)
    @NotNull(message = "descricao nivel obrigatorio")
    private TipoNivelUrgencia descricaoNivel;

    @OneToMany(mappedBy = "nivelUrgencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EnvironmentalNode> environmentalNodes;
}
