package com.glovo.ttglovo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@OpenAPIDefinition(info = @Info(title = "Team Team Delivery API", version = "3.0", description = "Do try our most delicious API"))
public class TtGlovoApplication {


    public static void main(String[] args) {
        SpringApplication.run(TtGlovoApplication.class, args);

    }

}
