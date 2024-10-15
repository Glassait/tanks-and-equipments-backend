package com.glassait.tanks_and_equipments;

import com.hazelcast.core.HazelcastInstance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class GlassaitApplicationTests {
    @MockBean
    private HazelcastInstance hazelcastInstance;

    @Test
    void contextLoads() {
        // This will check if the application context loads successfully
    }

    @Test
    void testApplicationStartup() {
        // You can verify the startup behavior here
        GlassaitApplication.main(new String[]{});
    }
}
