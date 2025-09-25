package com.alvesdev.Desafio.Cnab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cnab ParseFlow", version = "1", description = "A project designed to solve a challenge, with the intention of putting my knowledge into practice"))
public class CnabParseFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnabParseFlowApplication.class, args);
	}

}
