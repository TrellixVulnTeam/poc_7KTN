package com.foot.poc.controller;


import com.foot.poc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSignUp() throws Exception {
        mockMvc.perform(post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"first1\",\"lastname\": \"last1\" ,\"password\": \"password\", \"birthday\": \"1998-07-24\", \"address\": \"test\",\"email\": \"test@gmail.com\",\"phoneNumber\": \"07 60 08 80 50\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User created successfully"));

        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertEquals(1, userRepository.count());

        mockMvc.perform(post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"first1\",\"lastname\": \"last1\"," +
                                " \"password\": \"password\", \"birthday\": \"1998-07-24\", " +
                                "\"address\": \"test\",\"email\": \"test2@gmail.com\"," +
                                "\"phoneNumber\": \"07 60 08 80 50\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User created successfully"));

        assertEquals(2, userRepository.count());
    }


}
