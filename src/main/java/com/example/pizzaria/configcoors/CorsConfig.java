package com.example.pizzaria.configcoors;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry  registry ) {
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200") // Permitir apenas o Angular
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
        .allowedHeaders("*") // Headers permitidos
        .allowCredentials(true) // Permitir credenciais (cookies)
        .maxAge(3600);

    }
}