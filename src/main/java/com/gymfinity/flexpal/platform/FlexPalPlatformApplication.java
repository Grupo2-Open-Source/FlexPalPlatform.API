package com.gymfinity.flexpal.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlexPalPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlexPalPlatformApplication.class, args);
    }

}
