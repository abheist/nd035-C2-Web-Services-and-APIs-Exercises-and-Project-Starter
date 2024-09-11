package com.udacity.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void pricingServiceTest() throws Exception {
        Long carId = current().nextLong(1, 20);
        mvc.perform(MockMvcRequestBuilders.get("/services/price").param("vehicleId", String.valueOf(carId))).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andExpect(content().json("{}")).andExpect(jsonPath("$.currency").isString()).andExpect(jsonPath("$.price").isNumber()).andExpect(jsonPath("$.vehicleId").isNumber());
    }

}
