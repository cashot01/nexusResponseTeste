package br.com.fiap.nexus_response_api_teste.config;

import br.com.fiap.nexus_response_api_teste.model.*;
import br.com.fiap.nexus_response_api_teste.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/*@Component
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
    /*@PostConstruct
    public void init() {
        // Usuarios
        var usuarios = List.of(
                Usuario.builder().nome("Cauan Passos").email("cauan.passos@gmail.com").senha("senha123").papel(UsuarioPapel.ADMIN).cpf("12345678901").build(),
                Usuario.builder().nome("Mateus Henrique").email("mateus.henrique@gmail.com").senha("nexus2025").papel(UsuarioPapel.ADMIN).cpf("10987654321").build(),
                Usuario.builder().nome("Lucas Fialho").email("lucas.fialho@gmail.com").senha("responseFialho25").papel(UsuarioPapel.ADMIN).cpf("00011122233").build(),
                Usuario.builder().nome("João Silva").email("joao.silva@gmail.com").senha("silvaresponse01").papel(UsuarioPapel.USER).cpf("99988877766").build(),
                Usuario.builder().nome("Maria Clara").email("maria.clara@gmail.com").senha("claranexus2").papel(UsuarioPapel.USER).cpf("12378995124").build()
        );
        usuarioRepository.saveAll(usuarios);

        // StatusAgua
        var statusAgua = List.of(
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.BAIXO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.MODERADO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.ALTO).build(),
                StatusAgua.builder().descricaoAgua(TipoStatusAgua.CRITICO).build()
        );
        statusAguaRepository.saveAll(statusAgua);

        // NívelUrgência
        var nivelUrgencia = List.of(
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.BAIXO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.MEDIO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.ALTO).build(),
                NivelUrgencia.builder().descricaoNivel(TipoNivelUrgencia.CRITICO).build()
        );
        nivelUrgenciaRepository.saveAll(nivelUrgencia);

        // LocationTrackers
        var locations = List.of(
                LocationTracker.builder().latitude("-23.5505").longitude("-46.6333").data(LocalDate.parse("2023-10-01")).usuario(usuarios.get(0)).build(),
                LocationTracker.builder().latitude("-24.5155").longitude("-49.6933").data(LocalDate.parse("2023-11-11")).usuario(usuarios.get(1)).build(),
                LocationTracker.builder().latitude("-25.5555").longitude("-50.6444").data(LocalDate.parse("2024-01-01")).usuario(usuarios.get(2)).build(),
                LocationTracker.builder().latitude("-26.5665").longitude("-20.6333").data(LocalDate.parse("2024-07-22")).usuario(usuarios.get(3)).build(),
                LocationTracker.builder().latitude("-27.5777").longitude("-55.9874").data(LocalDate.parse("2024-12-12")).usuario(usuarios.get(4)).build()
        );
        locationTrackerRespository.saveAll(locations);

        // EnvinonmentalNodes
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
    } */

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NivelUrgenciaRepository nivelUrgenciaRepository;

    @Autowired
    private StatusAguaRepository statusAguaRepository;

    @Autowired
    private LocationTrackerRespository locationTrackerRepository;

    @Autowired
    private EnvironmentalNodeRepository environmentalNodeRepository;


    @Override
    public void run(String... args) throws Exception {
        seedNivelUrgencia();
        seedStatusAgua();
        seedUsuarios();
        seedLocationTrackers();
        seedEnvironmentalNodes();
    }

    private void seedNivelUrgencia() {
        if (nivelUrgenciaRepository.count() == 0) {
            nivelUrgenciaRepository.save(NivelUrgencia.builder()
                    .descricaoNivel(TipoNivelUrgencia.BAIXO)
                    .build());
            nivelUrgenciaRepository.save(NivelUrgencia.builder()
                    .descricaoNivel(TipoNivelUrgencia.MEDIO)
                    .build());
            nivelUrgenciaRepository.save(NivelUrgencia.builder()
                    .descricaoNivel(TipoNivelUrgencia.ALTO)
                    .build());
            nivelUrgenciaRepository.save(NivelUrgencia.builder()
                    .descricaoNivel(TipoNivelUrgencia.CRITICO)
                    .build());
        }
    }

    private void seedStatusAgua() {
        if (statusAguaRepository.count() == 0) {
            statusAguaRepository.save(StatusAgua.builder()
                    .descricaoAgua(TipoStatusAgua.BAIXO)
                    .build());
            statusAguaRepository.save(StatusAgua.builder()
                    .descricaoAgua(TipoStatusAgua.MODERADO)
                    .build());
            statusAguaRepository.save(StatusAgua.builder()
                    .descricaoAgua(TipoStatusAgua.ALTO)
                    .build());
            statusAguaRepository.save(StatusAgua.builder()
                    .descricaoAgua(TipoStatusAgua.CRITICO)
                    .build());
        }
    }

    private void seedUsuarios() {
        if (usuarioRepository.count() == 0) {
            // Usuário administrador
            usuarioRepository.save(Usuario.builder()
                    .nome("Administrador")
                    .cpf("12345678901")
                    .email("admin@nexus.com")
                    .senha("admin123")
                    .papel(UsuarioPapel.ADM)
                    .build());

            // Usuário comum
            usuarioRepository.save(Usuario.builder()
                    .nome("João Silva")
                    .cpf("98765432100")
                    .email("joao@nexus.com")
                    .senha("user123")
                    .papel(UsuarioPapel.USUARIO)
                    .build());
        }
    }

    private void seedLocationTrackers() {
        if (locationTrackerRepository.count() == 0) {
            locationTrackerRepository.save(LocationTracker.builder()
                    .latitude(new BigDecimal("-23.550520"))
                    .longitude(new BigDecimal("-46.633308"))
                    .data(LocalDate.now())
                    .build());

            locationTrackerRepository.save(LocationTracker.builder()
                    .latitude(new BigDecimal("-22.906847"))
                    .longitude(new BigDecimal("-43.172896"))
                    .data(LocalDate.now())
                    .build());
        }
    }

    private void seedEnvironmentalNodes() {
        if (environmentalNodeRepository.count() == 0) {
            Usuario usuario = usuarioRepository.findUsuarioByEmail("joao@nexus.com").orElse(null);
            NivelUrgencia nivelBaixo = nivelUrgenciaRepository.findByDescricaoNivel(TipoNivelUrgencia.BAIXO).orElse(null);
            StatusAgua statusModerado = statusAguaRepository.findByDescricaoAgua(TipoStatusAgua.MODERADO).orElse(null);
            LocationTracker location = locationTrackerRepository.findAll().get(0);

            if (usuario != null && nivelBaixo != null && statusModerado != null) {
                environmentalNodeRepository.save(EnvironmentalNode.builder()
                        .tempMedia(new BigDecimal("25.5"))
                        .tempDispositivo(new BigDecimal("26.0"))
                        .umidade(new BigDecimal("65.0"))
                        .nivelAgua(new BigDecimal("75.0"))
                        .usuario(usuario)
                        .nivelUrgencia(nivelBaixo)
                        .statusAgua(statusModerado)
                        .locationTracker(location)
                        .build());
            }
        }
    }
}
