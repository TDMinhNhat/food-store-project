package io.github.tdminhnhat.service;

import io.github.tdminhnhat.core.annotation.EnableLibraryCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibraryCore
public class CategoryServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }

}
