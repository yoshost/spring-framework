package com.yma.security;

import com.yma.security.entity.UserEntity;
import com.yma.security.repositorie.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder){

        return  args -> {
            UserEntity admin = UserEntity.builder()
                    .userName("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .roles("ROLE_ADMIN")
                    .build();

            UserEntity user = UserEntity.builder()
                    .userName("user")
                    .password(passwordEncoder.encode("user123"))
                    .roles("ROLE_USER")
                    .build();

            userRepository.saveAll(List.of(admin, user));
        };
    }

}
