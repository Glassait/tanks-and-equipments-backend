package com.glassait.tanks_and_equipments;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GlassaitApplicationTests {

    @Test
    void contextLoads() {
        // This will check if the application context loads successfully
    }

    @Test
    void testApplicationStartup() {
        // You can verify the startup behavior here
        String[] args = {};
        GlassaitApplication.main(args);
    }
}
