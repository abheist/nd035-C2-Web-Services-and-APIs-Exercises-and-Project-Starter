package com.udacity.vehicles.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle Service")
                        .description("This service returns vehicles data")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Udacity")
                                .url("https://www.udacity.com")
                                .email("udacity@udacity.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("http://localhost:8080")));
    }

}
