package io.github.tdminhnhat.service;

import io.github.tdminhnhat.core.annotation.EnableLibraryCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibraryCore
public class PosServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(PosServiceApplication.class, args);
    }

}
