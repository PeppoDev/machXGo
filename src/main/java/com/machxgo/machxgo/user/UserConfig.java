package com.machxgo.machxgo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User maria =  new User(
                    "Maria",
                    "maria@email.com",
                    "12345678",
                    "000.000.000-00",
                    "cpf"
            );

            User alex =  new User(
                    "alex",
                    "alex@email.com",
                    "12345678",
                    "000.000.000-00",
                    "cpf"
            );
            repository.saveAll(List.of(maria, alex));
        };
    }

}
