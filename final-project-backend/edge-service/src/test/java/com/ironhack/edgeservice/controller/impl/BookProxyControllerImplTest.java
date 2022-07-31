package com.ironhack.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.edgeservice.client.BalanceProxyClient;
import com.ironhack.edgeservice.client.BookProxyClient;
import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.impl.BalanceProxyServiceImpl;
import com.ironhack.edgeservice.service.impl.BookProxyServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookProxyControllerImplTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookProxyClient mockBookProxyClient;

    @MockBean
    private BookProxyServiceImpl mockBookProxyService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Book book1, book2;

    private List<Book> bookList;

    @BeforeEach
    void setUp() {
        book1 = new Book("Harry Potter",450,"JK Rowling");
        book2 = new Book("Charly y la fábrica de chocolate",142,"Roald Dahl");
       bookList.add(book1);
       bookList.add(book2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void postBook() throws Exception{
        Mockito.when(mockBookProxyService.postBook(book1))
                .thenReturn(book1);
        MvcResult mvcResult = mockMvc.perform(post("/books"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Harry"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));
    }



    @Test
    void findAvailableBooks() throws Exception{
        Mockito.when(mockBookProxyService.findAvailableBooks())
                .thenReturn(bookList);
        MvcResult mvcResult = mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Alice"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));
    }
}