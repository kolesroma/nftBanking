package com.kolesnyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class NftApplication {
    public static void main(String[] args) {
        SpringApplication.run(NftApplication.class, args);
    }
}
