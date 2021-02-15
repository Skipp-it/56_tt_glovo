package com.glovo.ttglovo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication()
@EnableConfigurationProperties()
public class TtGlovoApplication {


    public static void main(String[] args) {
        SpringApplication.run(TtGlovoApplication.class, args);
    }

}
