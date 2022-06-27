package com.hdy.jpa.config;

import com.hdy.jpa.entity.Users;
import com.hdy.jpa.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitConfig {
    @Bean
    CommandLineRunner initDatabase(UsersRepository repository) {
        // CommandLineRunner : once the application context is loaded.
        return args -> {
            log.info("Preloading " + repository.save(new Users("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Users("Frodo Baggins", "thief")));
        };
    }
}
