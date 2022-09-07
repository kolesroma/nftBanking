package com.kolesnyk;

import com.kolesnyk.repository.UserRepository;
import com.kolesnyk.model.User;
import com.kolesnyk.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NftApplication {

    public static void main(String[] args) {
        SpringApplication.run(NftApplication.class, args);
    }

    @Bean
    CommandLineRunner sd(UserService userService) {
        return args -> {
            System.out.println("userService.getById(1) = " + userService.getById(1));
        };
    }

}
