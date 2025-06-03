package br.com.fiap.nexus_response_api_teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "NexusResponse API", version = "v1", description = "API do projeto Nexus Response", contact = @Contact(name = "Cauan Passos", email = "cauan.passos@nexusResponse.com")))
public class NexusResponseApiTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexusResponseApiTesteApplication.class, args);
	}

}
