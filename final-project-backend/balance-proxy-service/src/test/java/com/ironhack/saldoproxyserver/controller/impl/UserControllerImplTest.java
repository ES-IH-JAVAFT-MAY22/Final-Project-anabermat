package com.ironhack.saldoproxyserver.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ironhack.saldoproxyserver.model.Book;
import com.ironhack.saldoproxyserver.model.User;
import com.ironhack.saldoproxyserver.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private User user1, user2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        user1 = new User("Pepito",10);
        user2 = new User("Jaime", 50);
        userRepository.saveAll(List.of(user1, user2));
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void postUser() throws Exception {
        User user = new User("Jaime", 50);
        String body = objectMapper.writeValueAsString(user);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/users")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Jaime"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Pepito"));
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUser() throws Exception {
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Pepito"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Jaime"));
    }

    @Test
    void updateBalance() throws Exception {

        Book book = new Book("Harry Potter",550, "JK Rowling");
        String body = objectMapper.writeValueAsString(book);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(put("/users/1")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("110"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("115"));

    }
}