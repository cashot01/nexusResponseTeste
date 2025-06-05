package br.com.fiap.nexus_response_api_teste.config;

import br.com.fiap.nexus_response_api_teste.model.*;
import br.com.fiap.nexus_response_api_teste.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private StatusAguaRepository statusAguaRepository;

    @Autowired
    private NivelUrgenciaRepository nivelUrgenciaRepository;

    @Autowired
    private LocationTrackerRespository locationTrackerRespository;

    @Autowired
    private EnvironmentalNodeRepository environmentalNodeRepository;



    /*@PostConstruct
    public void init() {
        var usuarios = List.of(
                Usuario.builder().nome("Cauan Passos").email("cauan.passos@gmail.com").senha(("senha123")).papel(UsuarioPapel.ADM).cpf("12345678901").build(),
                Usuario.builder().nome("Mateus Henrique").email("mateus.henrique@gmail.com").senha(("nexus2025")).papel(UsuarioPapel.ADM).cpf("10987654321").build(),
                Usuario.builder().nome("Lucas Fialho").email("lucas.fialho@gmail.com").senha(("responseFialho25")).papel(UsuarioPapel.ADM).cpf("00011122233").build(),
                Usuario.builder().nome("João Silva").email("joao.silva@gmail.com").senha(("silvaresponse01")).papel(UsuarioPapel.USUARIO).cpf("99988877766").build(),
                Usuario.builder().nome("Maria Clara").email("maria.clara@gmail.com").senha(("claranexus2")).papel(UsuarioPapel.USUARIO).cpf("12378995124").build()
        );
        usuarioRepository.saveAll(usuarios);

        var statusAgua = List.of(
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.BAIXO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.MODERADO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.ALTO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.CRITICO).build()
        );
        statusAguaRepository.saveAll(statusAgua);

        var nivelUrgencia = List.of(
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.BAIXO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.MEDIO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.ALTO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.CRITICO).build()
        );
        nivelUrgenciaRepository.saveAll(nivelUrgencia);

        var locationTrackrer = List.of(
                LocationTracker.builder().latitude("-23.5505").longitude("-46.6333").data(LocalDate.parse("2023-10-01")).build(),
                LocationTracker.builder().latitude("-24.5155").longitude("-49.6933").data(LocalDate.parse("2023-11-11")).build(),
                LocationTracker.builder().latitude("-25.5555").longitude("-50.6444").data(LocalDate.parse("2024-01-01")).build(),
                LocationTracker.builder().latitude("-26.5665").longitude("-20.6333").data(LocalDate.parse("2024-07-22")).build(),
                LocationTracker.builder().latitude("-27.5777").longitude("-55.9874").data(LocalDate.parse("2024-12-12")).build()
        );
        locationTrackerRespository.saveAll(locationTrackrer);

        var environmentalNode = List.of(
                EnvironmentalNode.builder().tempMedia(25.5).tempDispositivo(26.0).umidade(15.0).nivelAgua(15.0).build(),
                EnvironmentalNode.builder().tempMedia(25.5).tempDispositivo(26.0).umidade(45.0).nivelAgua(35.0).build(),
                EnvironmentalNode.builder().tempMedia(25.5).tempDispositivo(26.0).umidade(85.0).nivelAgua(70.0).build(),
                EnvironmentalNode.builder().tempMedia(25.5).tempDispositivo(26.0).umidade(77.0).nivelAgua(89.0).build(),
                EnvironmentalNode.builder().tempMedia(25.5).tempDispositivo(26.0).umidade(95.5).nivelAgua(98.8).build()
        );
        environmentalNodeRepository.saveAll(environmentalNode);

    } */
    @PostConstruct
    public void init() {
        // Usuários
        var usuarios = List.of(
                Usuario.builder().nome("Cauan Passos").email("cauan.passos@gmail.com").senha("senha123").papel(UsuarioPapel.ADM).cpf("12345678901").build(),
                Usuario.builder().nome("Mateus Henrique").email("mateus.henrique@gmail.com").senha("nexus2025").papel(UsuarioPapel.ADM).cpf("10987654321").build(),
                Usuario.builder().nome("Lucas Fialho").email("lucas.fialho@gmail.com").senha("responseFialho25").papel(UsuarioPapel.ADM).cpf("00011122233").build(),
                Usuario.builder().nome("João Silva").email("joao.silva@gmail.com").senha("silvaresponse01").papel(UsuarioPapel.USUARIO).cpf("99988877766").build(),
                Usuario.builder().nome("Maria Clara").email("maria.clara@gmail.com").senha("claranexus2").papel(UsuarioPapel.USUARIO).cpf("12378995124").build()
        );
        usuarioRepository.saveAll(usuarios);

        // Status da Água
        var statusAgua = List.of(
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.BAIXO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.MODERADO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.ALTO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.CRITICO).build()
        );
        statusAguaRepository.saveAll(statusAgua);

        // Nível de Urgência
        var nivelUrgencia = List.of(
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.BAIXO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.MEDIO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.ALTO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.CRITICO).build()
        );
        nivelUrgenciaRepository.saveAll(nivelUrgencia);

        // Localizações
        var locations = List.of(
                LocationTracker.builder().latitude("-23.5505").longitude("-46.6333").data(LocalDate.parse("2023-10-01")).usuario(usuarios.get(0)).build(),
                LocationTracker.builder().latitude("-24.5155").longitude("-49.6933").data(LocalDate.parse("2023-11-11")).usuario(usuarios.get(1)).build(),
                LocationTracker.builder().latitude("-25.5555").longitude("-50.6444").data(LocalDate.parse("2024-01-01")).usuario(usuarios.get(2)).build(),
                LocationTracker.builder().latitude("-26.5665").longitude("-20.6333").data(LocalDate.parse("2024-07-22")).usuario(usuarios.get(3)).build(),
                LocationTracker.builder().latitude("-27.5777").longitude("-55.9874").data(LocalDate.parse("2024-12-12")).usuario(usuarios.get(4)).build()
        );
        locationTrackerRespository.saveAll(locations);

        // Nós Ambientais
        var nodes = List.of(
                EnvironmentalNode.builder()
                        .tempMedia(25.5).tempDispositivo(26.0).umidade(15.0).nivelAgua(15.0)
                        .locationTracker(locations.get(0))
                        .nivelUrgencia(nivelUrgencia.get(0))
                        .statusAgua(statusAgua.get(0))
                        .usuario(usuarios.get(0))
                        .build(),
                EnvironmentalNode.builder()
                        .tempMedia(25.5).tempDispositivo(26.0).umidade(45.0).nivelAgua(35.0)
                        .locationTracker(locations.get(1))
                        .nivelUrgencia(nivelUrgencia.get(1))
                        .statusAgua(statusAgua.get(1))
                        .usuario(usuarios.get(1))
                        .build(),
                EnvironmentalNode.builder()
                        .tempMedia(25.5).tempDispositivo(26.0).umidade(85.0).nivelAgua(70.0)
                        .locationTracker(locations.get(2))
                        .nivelUrgencia(nivelUrgencia.get(2))
                        .statusAgua(statusAgua.get(2))
                        .usuario(usuarios.get(2))
                        .build(),
                EnvironmentalNode.builder()
                        .tempMedia(25.5).tempDispositivo(26.0).umidade(77.0).nivelAgua(89.0)
                        .locationTracker(locations.get(3))
                        .nivelUrgencia(nivelUrgencia.get(3))
                        .statusAgua(statusAgua.get(3))
                        .usuario(usuarios.get(3))
                        .build(),
                EnvironmentalNode.builder()
                        .tempMedia(25.5).tempDispositivo(26.0).umidade(95.5).nivelAgua(98.8)
                        .locationTracker(locations.get(4))
                        .nivelUrgencia(nivelUrgencia.get(0))
                        .statusAgua(statusAgua.get(0))
                        .usuario(usuarios.get(4))
                        .build()
        );
        environmentalNodeRepository.saveAll(nodes);
    }

}
