package com.first.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management App")
                        .version("1.0")
                        .description("API documentation for Employee Management System"))
        .servers(List.of(
            new Server().url("http://localhost:8080").description("Local server"),
            new Server().url("https://localhost:8081").description("Production server")
        ));
    }
}
