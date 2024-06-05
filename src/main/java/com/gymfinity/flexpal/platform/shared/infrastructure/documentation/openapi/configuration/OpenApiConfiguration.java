package com.gymfinity.flexpal.platform.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI flexPalPlatformApi() {
        var OpenApi = new OpenAPI();
        OpenApi
                .info(new Info()
                        .title("Flex Pal Platform API")
                        .description("Flex Pal Platform application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Flex Pal Platform wiki Documentation")
                        .url("https://flex-pal-platform.wiki.github.io/docs"));
        return OpenApi;
    }
}
