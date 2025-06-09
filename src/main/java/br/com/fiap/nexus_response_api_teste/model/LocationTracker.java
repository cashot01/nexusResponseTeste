package br.com.fiap.nexus_response_api_teste.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_NEXUS_LOCATION_TRACKER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Long idLocation;

    @NotBlank(message = "latitude obrigatoria")
    @Column(name = "latitude", nullable = false, precision = 9, scale = 6)
    private String latitude;

    @NotBlank(message = "longitude obrigatoria")
    @Column(name = "longitude", nullable = false, precision = 9, scale = 6)
    private String longitude;

    @Column(name = "data", nullable = false)
    @NotNull(message = "Data obrigatoria")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "A data de cadastro não pode ser futura")
    private LocalDate data;

    @OneToMany(mappedBy = "locationTracker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EnvironmentalNode> environmentalNodes;
}
