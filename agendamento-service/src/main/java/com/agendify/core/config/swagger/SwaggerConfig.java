package com.agendify.core.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Agendamento Service API")
                        .version("1.0.0")
                        .description("API REST para gerenciamento de agendamentos e serviços.")
                        .contact(new Contact()
                                .name("Samuel Figueiredo")
                                .email("samuelfigsre@gmail.com")
                                .url("https://www.linkedin.com/in/samuelfigueired/"))
                );
    }
}
