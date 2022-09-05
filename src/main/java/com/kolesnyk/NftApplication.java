package com.kolesnyk;

import com.kolesnyk.repository.UserRepository;
import com.kolesnyk.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NftApplication {

    public static void main(String[] args) {
        SpringApplication.run(NftApplication.class, args);
    }

//    @Bean
    CommandLineRunner sd(UserRepository rep) {
        return args -> {
            rep.save(new User());
        };
    }

}
