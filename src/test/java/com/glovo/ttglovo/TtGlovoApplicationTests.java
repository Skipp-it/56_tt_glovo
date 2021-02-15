package com.glovo.ttglovo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class TtGlovoApplicationTests {

    @Test
    void contextLoads() {
       System.out.println(new BCryptPasswordEncoder().encode("test"));
    }

}
