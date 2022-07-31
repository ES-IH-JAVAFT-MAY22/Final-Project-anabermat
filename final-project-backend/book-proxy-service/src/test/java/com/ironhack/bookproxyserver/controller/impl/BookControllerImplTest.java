package com.ironhack.bookproxyserver.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ironhack.bookproxyserver.model.Book;
import com.ironhack.bookproxyserver.repository.BookRepository;
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
class BookControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BookRepository bookRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Book book1, book2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        book1 = new Book("Harry Potter",450,"JK Rowling");
        book2 = new Book("Charly y la fábrica de chocolate",142,"Roald Dahl");
        bookRepository.saveAll(List.of(book1,book2));
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void postBook() throws Exception {
        Book book = new Book("Harry Potter",450,"JK Rowling");
        String body = objectMapper.writeValueAsString(book);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/books")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Harry Potter"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Charly"));
    }

    @Test
    void getBook() throws Exception{
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Harry Potter"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Charly"));
    }

    @Test
    void findAvailableBooks() throws Exception{
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Harry Potter"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Alice"));
    }

}