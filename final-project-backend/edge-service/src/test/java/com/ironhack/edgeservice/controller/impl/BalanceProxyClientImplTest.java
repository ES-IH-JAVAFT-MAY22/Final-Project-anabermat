package com.ironhack.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.edgeservice.client.BalanceProxyClient;
import com.ironhack.edgeservice.client.BookProxyClient;
import com.ironhack.edgeservice.model.Book;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.impl.BalanceProxyServiceImpl;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BalanceProxyClientImplTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BalanceProxyClient mockBalanceProxyClient;

    @MockBean
    private BalanceProxyServiceImpl mockBalanceProxyService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private User user1, user2;

    private Book book1;

    private List<Book> bookList1;

    @BeforeEach
    void setUp() {
        user1 = new User("Pepito",10);
        book1 = new Book("Alice in Wonderland",550,"Lewis Carroll");
        bookList1 = new ArrayList<>();
        bookList1.add(book1);
        user1.setBookList(bookList1);
        user2 = new User("Jaime", 50);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void postUser() throws Exception {
        Mockito.when(mockBalanceProxyService.postUser(user1))
                .thenReturn(user1);
        MvcResult mvcResult = mockMvc.perform(post("/users"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Pepito"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));
    }


    @Test
    void getUser() throws Exception{
        Mockito.when(mockBalanceProxyService.getUser(1))
                .thenReturn(user1);
        MvcResult mvcResult = mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Pepito"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));
    }

    @Test
    void updateBalance() throws Exception {
        Mockito.when(mockBalanceProxyService.updateBalance(1,book1))
                .thenReturn(user1);
        MvcResult mvcResult = mockMvc.perform(put("/users/up/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("110"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("150"));
    }

    @Test
    void getBookList() throws Exception{
        Mockito.when(mockBalanceProxyService.getBookList(1))
                .thenReturn(bookList1);
        MvcResult mvcResult = mockMvc.perform(get("/users/bookList/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Alice"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));
    }

}