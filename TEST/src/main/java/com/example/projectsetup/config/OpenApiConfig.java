package com.example.projectsetup.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI projectOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Project Setup API")
                        .description("API documentation for payment operations.")
                        .version("v1")
                        .contact(new Contact().name("Project Setup Team"))
                        .license(new License().name("Apache 2.0")));
    }
}
