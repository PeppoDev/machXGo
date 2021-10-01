package com.machxgo.machxgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// classes
import com.machxgo.machxgo.user.User;

import java.util.List;

@SpringBootApplication
public class MachXGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MachXGoApplication.class, args);
    }
}

