package io.github.tdminhnhat.service;

import io.github.tdminhnhat.core.annotation.EnableLibraryCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibraryCore
public class UserServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
