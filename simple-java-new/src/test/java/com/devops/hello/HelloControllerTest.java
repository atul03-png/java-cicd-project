package com.devops.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void home_returnsHelloMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from Jenkins CI/CD Pipeline!"))
                .andExpect(jsonPath("$.status").value("running"));
    }

    @Test
    void hello_withName_returnsPersonalizedMessage() throws Exception {
        mockMvc.perform(get("/hello/Rahul"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, Rahul!"));
    }
}
